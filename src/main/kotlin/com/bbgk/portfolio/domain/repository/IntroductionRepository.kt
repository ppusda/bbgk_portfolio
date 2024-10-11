package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.Achievement
import com.bbgk.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}