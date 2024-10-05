package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>