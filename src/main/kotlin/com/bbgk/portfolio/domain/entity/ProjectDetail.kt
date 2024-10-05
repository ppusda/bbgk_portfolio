package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectDetail : BaseEntity() {

    @Id
    @Column(name = "project_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}