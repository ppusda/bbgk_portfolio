package com.bbgk.portfolio.admin.context.achievement.service

import com.bbgk.portfolio.admin.data.TableDTO
import com.bbgk.portfolio.domain.entity.Achievement
import com.bbgk.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
        private val achievementRepository: AchievementRepository // TODO: PresentationRespository (퍼사드 패턴) 과 뭐가 더 유리한지
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}