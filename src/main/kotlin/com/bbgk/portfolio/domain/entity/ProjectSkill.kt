package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(
        project: Project,
        skill: Skill
) : BaseEntity() {

    @Id
    @Column(name = "project_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    var project: Project = project

    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill: Skill = skill
}