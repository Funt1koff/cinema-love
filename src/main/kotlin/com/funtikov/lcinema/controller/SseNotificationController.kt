package com.funtikov.lcinema.controller

import com.funtikov.lcinema.service.impl.SseNotificationService
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

@RestController
@RequestMapping("api/v1/notification/sse")
class SseNotificationController(val notificationService: SseNotificationService) {

    @GetMapping("/subscribe")
    fun subscribe(): SseEmitter {
        val username = SecurityContextHolder.getContext().authentication.name
        notificationService.register(username)
        return notificationService.getEmitter(username) ?: throw IllegalStateException("Emitter not found")
    }
}