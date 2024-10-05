package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement( // 여기가 생성자
        title: String,
        description: String,
        achievedDate: LocalDate?, // null 허용 (=일 수도 있다.) / 반대로 !!는 null이 아니다를 표현함
        host: String,
        isActive: Boolean
) : BaseEntity() { // BaseEntity 상속

    @Id
    @Column(name = "achievement_id") // 필드 값을 id로 깔끔하게 사용하고, 이름을 테이블명_id로 매핑하기 위해 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var title: String = title

    var description: String = description

    var achievedDate: LocalDate? = achievedDate

    var host: String = host

    var isActive: Boolean = isActive

}