package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience : BaseEntity() {

    @Id
    @Column(name = "experience_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}