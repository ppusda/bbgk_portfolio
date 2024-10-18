package com.bbgk.portfolio.admin.interceptor

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

@Component
class AdminInterceptor : HandlerInterceptor{
    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any, modelAndView: ModelAndView?) {
        val menus = listOf<MenuDTO> (
                MenuDTO(
                        name = "Index",
                        pages = listOf<PageDTO>(
                                PageDTO(name = "Introduction", "/admin/introduction"),
                                PageDTO(name = "Link", "/admin/link"),
                        )
                ),
                MenuDTO(
                        name = "Resume",
                        pages = listOf<PageDTO>(
                                PageDTO(name = "Experience", "/admin/experience"),
                                PageDTO(name = "Achievement", "/admin/achievement"),
                                PageDTO(name = "Skill", "/admin/skill"),
                        )
                ),
                MenuDTO(
                        name = "Project",
                        pages = listOf<PageDTO>(
                                PageDTO(name = "Project", "/admin/project"),
                                PageDTO(name = "ProjectSkill", "/admin/project/skill"),
                        )
                )
        )

        modelAndView?.model?.put("menus", menus)
    }
}