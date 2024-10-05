package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Introduction(
        content: String,
        isActive: Boolean
) : BaseEntity() {

    @Id
    @Column(name = "introduction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var content: String = content

    var isActive: Boolean = isActive
}