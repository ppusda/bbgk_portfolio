package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Link(
        name: String,
        content: String,
        isActive: Boolean
) : BaseEntity() {

    @Id
    @Column(name = "link_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String = name

    var content: String = content

    var isActive: Boolean = isActive
}