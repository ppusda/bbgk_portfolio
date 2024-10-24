package com.bbgk.portfolio.domain.repository

import com.bbgk.portfolio.domain.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AccountRepository : JpaRepository<Account, Long> {
    fun findByLoginId(loginId: String): Optional<Account>
}