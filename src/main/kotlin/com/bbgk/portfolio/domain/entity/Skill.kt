package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Skill : BaseEntity() {

    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}