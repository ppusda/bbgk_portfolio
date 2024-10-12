package com.bbgk.portfolio.presentation.repository

import com.bbgk.portfolio.domain.entity.*
import com.bbgk.portfolio.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository( // Presentation 에서 필요한 리포지토리들을 한 번에 주입받아서 활용하기 위함.
                                // A, B, C 형태로 따로따로 주입받으면 후에 관리하기가 힘들기 때문
        private val achievementRepository: AchievementRepository,
        private val experienceRepository: ExperienceRepository,
        private val introductionRepository: IntroductionRepository,
        private val linkRepository: LinkRepository,
        private val projectRepository: ProjectRepository,
        private val skillRepository: SkillRepository,
) {
    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }
    fun getActiveExperiences(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }
    fun getActiveIntroductions(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }
    fun getActiveLinks(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }
    fun getActiveProjects(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }
    fun getActiveSkills(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }
}