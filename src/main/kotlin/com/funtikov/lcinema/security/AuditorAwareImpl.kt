package com.funtikov.lcinema.security

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.*

@Component("auditorProvider")
class AuditorAwareImpl : AuditorAware<String> {

    override fun getCurrentAuditor(): Optional<String> {
        val username = SecurityContextHolder
            .getContext().authentication.name
        return Optional.of(username)
    }
}