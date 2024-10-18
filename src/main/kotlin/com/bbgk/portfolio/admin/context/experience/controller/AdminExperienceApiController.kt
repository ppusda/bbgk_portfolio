package com.bbgk.portfolio.admin.context.experience.controller

import com.bbgk.portfolio.admin.context.experience.form.ExperienceForm
import com.bbgk.portfolio.admin.context.experience.service.AdminExperienceService
import com.bbgk.portfolio.admin.data.ApiResponse
import com.bbgk.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/api/experiences")
class AdminExperienceApiController(
        private val adminExperienceService: AdminExperienceService
) {

    @PostMapping
    fun postExperience(@RequestBody @Validated form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun postExperience(@PathVariable id: Long, @RequestBody @Validated form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.update(id, form)
        return ApiResponse.successUpdate()
    }

    @GetMapping("/{id}/details")
    fun getExperienceDetails(@PathVariable id: Long): TableDTO {
        return adminExperienceService.getExperienceDetailTable(id)
    }
}