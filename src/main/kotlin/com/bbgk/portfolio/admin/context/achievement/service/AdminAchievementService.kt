package com.bbgk.portfolio.admin.context.achievement.service

import com.bbgk.portfolio.admin.context.achievement.form.AchievementForm
import com.bbgk.portfolio.admin.data.TableDTO
import com.bbgk.portfolio.domain.entity.Achievement
import com.bbgk.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminAchievementService(
        private val achievementRepository: AchievementRepository // TODO: PresentationRespository (퍼사드 패턴) 과 뭐가 더 유리한지
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: AchievementForm) {
        val achievement = form.toEntity()
        achievementRepository.save(achievement)
    }

    @Transactional
    fun update(id: Long, form: AchievementForm) {
        val achievement = form.toEntity(id)
        achievementRepository.save(achievement)
    }
}