package com.funtikov.lcinema.service.impl

import com.funtikov.lcinema.service.NotificationService
import org.springframework.stereotype.Service
import org.springframework.web.socket.WebSocketSession

@Service
class WebSocketNotificationService : NotificationService {

    val connections = mutableMapOf<String, WebSocketSession>()
    override fun register(username: String) {
        TODO("Not yet implemented")
    }

    override fun notifyUser(username: String, message: String) {
        TODO("Not yet implemented")
    }

    override fun closeConnection(username: String) {
        TODO("Not yet implemented")
    }
}