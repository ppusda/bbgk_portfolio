package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction : BaseEntity() {

    @Id
    @Column(name = "introduction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}