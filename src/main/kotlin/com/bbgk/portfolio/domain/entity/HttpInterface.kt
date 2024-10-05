package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class HttpInterface : BaseEntity() {

    @Id
    @Column(name = "http_interface_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}