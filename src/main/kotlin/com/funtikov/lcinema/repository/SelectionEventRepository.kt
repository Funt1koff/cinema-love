package com.funtikov.lcinema.repository

import com.funtikov.lcinema.entity.SelectionEvent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SelectionEventRepository : JpaRepository<SelectionEvent, Long> {
    fun findByInvitedViewerId(invitedViewerId: Long) : SelectionEvent
}