package com.bbgk.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest

@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {

    @Id
    @Column(name = "http_interface_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var cookies: String? = httpServletRequest.cookies
            ?.map { "${it.name}:${it.value}" } // cookie의 key-value 형태의 값을 포맷하여 저장
            ?.toString()

    var referer: String? = httpServletRequest.getHeader("referer") // referer - 요청 정보 저장

    var localAddr: String? = httpServletRequest.localAddr

    var remoteAddr: String? = httpServletRequest.remoteAddr

    var remoteHost: String? = httpServletRequest.remoteHost

    var requestUri: String? = httpServletRequest.requestURI

    var userAgent: String? = httpServletRequest.getHeader("user-agent")
}