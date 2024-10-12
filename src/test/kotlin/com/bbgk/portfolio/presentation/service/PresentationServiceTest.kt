package com.bbgk.portfolio.presentation.service

import com.bbgk.portfolio.domain.entity.Introduction
import com.bbgk.portfolio.domain.entity.Link
import com.bbgk.portfolio.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class) // Mockito Extension 추가
class PresentationServiceTest {

    @InjectMocks // Mock을 주입받을 대상, 테스트를 할 대상
    lateinit var presentationService: PresentationService // Mock을 만든 이후 초기화를 진행하기 위해 lateinit

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9

    @Test
    fun testGetIntroduction() { // Test의 Step을 구분함
        // given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0) // 짝수인 경우만
            introductions.add(introduction)
        }

        val activeIntroductions = introductions.filter { introduction ->
            introduction.isActive
        }

        Mockito.`when`(presentationRepository.getActiveIntroductions())
                .thenReturn(activeIntroductions) // when에서 정의한 내용을 시도했을 때, activeIntroductions를 return 하도록 Mocking을 함

        // when
        val introductionDTOs = presentationService.getIntroductions()

        // then
        assertThat(introductionDTOs).hasSize(DATA_SIZE / 2)
        for (introductionDTO in introductionDTOs) {
            assertThat(introductionDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks() {
        // given
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE) {
            val link = Link(name = "${i}", content = "${i}", isActive = i % 2 != 0) // 홀수인 경우만
            links.add(link)
        }

        val activeLinks = links.filter { link ->
            link.isActive
        }

        Mockito.`when`(presentationRepository.getActiveLinks())
                .thenReturn(activeLinks)

        // when
        val linkDTOs = presentationService.getLinks()

        // then
        var expectedSize = DATA_SIZE / 2;
        if (DATA_SIZE % 2 != 0) {
            expectedSize += 1
        }

        assertThat(linkDTOs).hasSize(expectedSize)
        for (linkDTO in linkDTOs) {
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }
}