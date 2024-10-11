package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {
    fun findAllByProjectIdAndSkillId(projectId: Long, skillId: Long): List<ProjectSkill>

}