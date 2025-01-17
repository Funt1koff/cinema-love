package com.funtikov.lcinema.service

import com.funtikov.lcinema.dto.request.RequestSelectionEventDto
import com.funtikov.lcinema.entity.SelectionEvent

interface SelectionEventService {
    fun createSelectionEvent(requestSelectionEventDto: RequestSelectionEventDto) : String
    fun approveInviteToSelectionEvent(): SelectionEvent
}