package com.funtikov.lcinema.service

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter

interface NotificationService {

    fun register(username: String)

    fun notifyUser(username: String, message: String)

    fun closeConnection(username: String)

}