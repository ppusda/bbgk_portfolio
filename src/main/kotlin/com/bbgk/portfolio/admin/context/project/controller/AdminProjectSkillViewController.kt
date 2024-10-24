package com.bbgk.portfolio.admin.context.project.controller

import com.bbgk.portfolio.admin.context.project.service.AdminProjectService
import com.bbgk.portfolio.admin.context.project.service.AdminProjectSkillService
import com.bbgk.portfolio.admin.data.FormElementDTO
import com.bbgk.portfolio.admin.data.SelectFormElementDTO
import com.bbgk.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/project/skill")
class AdminProjectSkillViewController(
        private val adminProjectSkillService: AdminProjectSkillService
) {

    @GetMapping
    fun projectSkill(model: Model): String {
        val projectList = adminProjectSkillService.getProjectList()
        val skillList = adminProjectSkillService.getSkillList()

        val formElements = listOf<FormElementDTO> (
                SelectFormElementDTO("project", 8, projectList),
                SelectFormElementDTO("skill", 8, skillList),
        )
        model.addAttribute("formElements", formElements)

        val table = adminProjectSkillService.getProjectTable()
        model.addAttribute("table", table)
        model.addAttribute("detailTable", null)

        val pageAttributes = mutableMapOf<String, Any>(
                Pair("menuName", "Project"),
                Pair("pageName", table.name),
                Pair("editable", false),
                Pair("deletable", true),
                Pair("hasDetails", false)
        )
        model.addAllAttributes(pageAttributes)

        return "admin/page-table"
    }
}