package com.bbgk.portfolio.admin.context.introduction.form

import com.bbgk.portfolio.domain.entity.Introduction
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class IntroductionForm(
        @field:NotBlank(message = "필수 값입니다.")
        val content: String,
        val isActive: Boolean
) {
    fun toEntity(): Introduction {
        return Introduction(
                content = this.content,
                isActive = this.isActive
        )
    }

    fun toEntity(id:Long): Introduction {
        val introduction = this.toEntity()
        introduction.id = id
        return introduction
    }
}