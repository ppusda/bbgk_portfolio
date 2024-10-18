package com.bbgk.portfolio.admin.context.link.service

import com.bbgk.portfolio.admin.data.TableDTO
import com.bbgk.portfolio.domain.entity.Link
import com.bbgk.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service

@Service
class AdminLinkService(
        private val linkRepository: LinkRepository
) {

    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}