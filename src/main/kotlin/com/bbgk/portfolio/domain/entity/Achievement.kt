package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Achievement : BaseEntity() { // BaseEntity 상속

    @Id
    @Column(name = "achievement_id") // 필드 값을 id로 깔끔하게 사용하고, 이름을 테이블명_id로 매핑하기 위해 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

}