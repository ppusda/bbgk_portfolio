package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ProjectSkillRepository : JpaRepository<ProjectSkill, Long> {
    fun findByProjectIdAndSkillId(projectId: Long, skillId: Long): Optional<ProjectSkill>

}