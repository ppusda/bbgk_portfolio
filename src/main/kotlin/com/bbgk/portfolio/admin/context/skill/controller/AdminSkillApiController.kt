package com.bbgk.portfolio.admin.context.skill.controller

import com.bbgk.portfolio.admin.context.skill.form.SkillForm
import com.bbgk.portfolio.admin.context.skill.service.AdminSkillService
import com.bbgk.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/api/skill")
class AdminSkillApiController(
        private val adminSkillService: AdminSkillService
) {

    @PostMapping
    fun postSkill(@RequestBody @Validated form: SkillForm): ResponseEntity<Any> {
        adminSkillService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun postSkill(@PathVariable id: Long, @RequestBody @Validated form: SkillForm): ResponseEntity<Any> {
        adminSkillService.update(id, form)
        return ApiResponse.successUpdate()
    }
}