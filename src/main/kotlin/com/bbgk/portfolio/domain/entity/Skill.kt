package com.bbgk.portfolio.domain.entity

import com.bbgk.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
        name: String,
        type: String,
        isActive: Boolean
) : BaseEntity() {

    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String = name

    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)

    var isActive: Boolean = isActive
}