package com.bbgk.portfolio.presentation.dto

import com.bbgk.portfolio.domain.entity.Introduction

data class IntroductionDTO(
        val content: String
){
    constructor(introduction: Introduction) : this(
            content = introduction.content
    )
}