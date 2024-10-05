package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill : BaseEntity() {

    @Id
    @Column(name = "project_skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}