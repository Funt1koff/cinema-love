package com.funtikov.lcinema.service.impl

import com.funtikov.lcinema.service.NotificationService
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.concurrent.ConcurrentHashMap

@Service
class SseNotificationService : NotificationService {

    private val emitters = ConcurrentHashMap<String, SseEmitter>()

    override fun register(username: String) {
        val emitter = SseEmitter(30_000)
        emitter.onCompletion {emitters.remove(username)}
        emitter.onTimeout {emitters.remove(username)}
        emitters[username] = emitter
    }

    override fun notifyUser(username: String, message: String) {
        val emitter = emitters[username]
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().data(message))
            } catch (e: Exception) {
                emitters.remove(username)
            }
        }
    }

    override fun closeConnection(username: String) {
        emitters[username]?.complete()
        emitters.remove(username)
    }

    fun getEmitter(username: String) : SseEmitter? {
        return emitters[username]
    }

}