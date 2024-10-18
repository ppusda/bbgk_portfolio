package com.bbgk.portfolio.admin.context.link.controller

import com.bbgk.portfolio.admin.context.link.form.LinkForm
import com.bbgk.portfolio.admin.context.link.service.AdminLinkService
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
@RequestMapping("/admin/api/link")
class AdminLinkApiController(
        private val adminLinkService: AdminLinkService
) {

    @PostMapping
    fun postLink(@RequestBody @Validated form: LinkForm): ResponseEntity<Any> {
        adminLinkService.save(form)
        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun postLink(@PathVariable id: Long, @RequestBody @Validated form: LinkForm): ResponseEntity<Any> {
        adminLinkService.update(id, form)
        return ApiResponse.successUpdate()
    }
}