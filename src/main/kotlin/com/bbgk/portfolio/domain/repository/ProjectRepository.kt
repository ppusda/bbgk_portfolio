package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ProjectRepository : JpaRepository<Project, Long> {
    @Query("select p from Project p left join fetch p.skills s join fetch s.skill where p.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Project>
    // skill만 fetch join 하여 N+1 문제가 그대로인데, 이를 해결하기 위해 fetch size로 조정하여 한번에 10개의 데이터를 묶어서 가져올 수 있었음
    @Query("select p from Project p join fetch p.details where p.id = :id")
    override fun findById(id: Long): Optional<Project>

}