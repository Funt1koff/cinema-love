package com.funtikov.lcinema.controller

import com.funtikov.lcinema.dto.request.RequestSelectionEventDto
import com.funtikov.lcinema.service.SelectionEventService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/event/selection")
class SelectionEventController (val selectionEventService: SelectionEventService) {

    @PostMapping("/initialize")
    fun initializeNewSelectionEvent(@RequestBody requestSelectionEventDto: RequestSelectionEventDto) {
        selectionEventService.createSelectionEvent(requestSelectionEventDto)
    }

    @PostMapping("/approve")
    fun approveInviteToSelectionEvent() {
        selectionEventService.approveInviteToSelectionEvent()
    }
}