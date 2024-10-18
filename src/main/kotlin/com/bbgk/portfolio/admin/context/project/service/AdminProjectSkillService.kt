package com.bbgk.portfolio.admin.context.project.service

import com.bbgk.portfolio.admin.data.TableDTO
import com.bbgk.portfolio.admin.exception.AdminBadRequestException
import com.bbgk.portfolio.domain.entity.Project
import com.bbgk.portfolio.domain.entity.ProjectDetail
import com.bbgk.portfolio.domain.repository.ProjectRepository
import com.bbgk.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminProjectSkillService(
        private val projectRepository: ProjectRepository,
        private val skillRepository: SkillRepository
) {

    @Transactional(readOnly = true)
    fun getProjectTable(): TableDTO {
        val projects = projectRepository.findAll()
        val columns = mutableListOf<String>(
                "id", "project", "projectName", "skillId", "skillName",
                "createdDateTime", "updatedDateTime"
        )
        val records = mutableListOf<MutableList<String>>()
        for (project in projects) {
            project.skills.forEach {
                val record = mutableListOf<String>()
                record.add(it.id.toString())
                record.add(it.project.id.toString())
                record.add(it.project.name)
                record.add(it.skill.id.toString())
                record.add(it.skill.name)
                record.add(it.skill.createdDateTime.toString())
                record.add(it.skill.updatedDateTime.toString())
                records.add(record)
            }
        }

        return TableDTO(name = "ProjectSkill", columns = columns, records = records)
    }

    fun getProjectList(): List<String> {
        val projects = projectRepository.findAll()
        return projects.map { "${it.id} (${it.name})"}.toList()
    }

    fun getSkillList(): List<String> {
        val skills = skillRepository.findAll()
        return skills.map { "${it.id} (${it.name})"}.toList()
    }

}