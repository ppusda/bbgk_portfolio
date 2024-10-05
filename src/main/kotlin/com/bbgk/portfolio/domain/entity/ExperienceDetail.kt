package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail : BaseEntity() {

    @Id
    @Column(name = "experience_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}