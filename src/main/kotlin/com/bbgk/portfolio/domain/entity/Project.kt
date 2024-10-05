package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project : BaseEntity() {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}