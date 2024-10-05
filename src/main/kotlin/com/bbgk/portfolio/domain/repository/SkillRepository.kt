package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>