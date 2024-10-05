package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Link : BaseEntity() {

    @Id
    @Column(name = "link_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}