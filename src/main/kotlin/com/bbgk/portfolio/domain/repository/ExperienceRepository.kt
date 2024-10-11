package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ExperienceRepository : JpaRepository<Experience, Long> {
    @Query("select e from Experience e left join fetch e.details where e.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>
    // fetchType = EAGER와 LAZY로 설정한 경우, 부모 조회 쿼리 + 자식의 개수 N개를 조회하는 N+1 문제가 발생
    // 이를 해결하기 위해 join을 사용, 그 중에서도 left join을 사용하여 전체를 가져오도록 설정

    @Query("select e from Experience e join fetch e.details where e.id = :id") // JPQL
    override fun findById(id: Long): Optional<Experience>

}