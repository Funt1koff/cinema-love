package com.funtikov.lcinema.service.impl

import com.funtikov.lcinema.dto.request.RequestSelectionEventDto
import com.funtikov.lcinema.entity.SelectionEvent
import com.funtikov.lcinema.repository.SelectionEventRepository
import com.funtikov.lcinema.repository.ViewerRepository
import com.funtikov.lcinema.service.NotificationService
import com.funtikov.lcinema.service.SelectionEventService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Duration
import java.time.LocalDateTime

@Service
class SelectionEventServiceImpl(
    val selectionEventRepository: SelectionEventRepository,
    val viewerRepository: ViewerRepository,
    val notificationService: NotificationService
) : SelectionEventService {

    val log: Logger = LoggerFactory.getLogger(SelectionEventServiceImpl::class.java)

    @Transactional
    override fun createSelectionEvent(requestSelectionEventDto: RequestSelectionEventDto): String {
        val creator = viewerRepository.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val invitedViewer = viewerRepository.findByUsername(requestSelectionEventDto.invitedViewerUsername)

        log.info("Start creating selection event by creator: ${creator.username}, invited viewer:" +
                " ${requestSelectionEventDto.invitedViewerUsername}")

        var createdSelectionEvent = SelectionEvent(creator = creator, invitedViewer = invitedViewer)
        createdSelectionEvent = selectionEventRepository.save(createdSelectionEvent)

        log.info("Selection event created with UUID: ${createdSelectionEvent.eventId}, " +
                "wait approve from ${invitedViewer.username}. Expiration invation time left:" +
                " ${Duration.between(createdSelectionEvent.expireInvitedDate, LocalDateTime.now()).toMinutes()} min.")
        return createdSelectionEvent.eventId
    }

    @Transactional
    override fun approveInviteToSelectionEvent() : SelectionEvent {
        val viewerUsername = viewerRepository.findByUsername(SecurityContextHolder.getContext().authentication.name)
        var invitedSelectionEvent = viewerUsername.id?.let { selectionEventRepository.findByInvitedViewerId(it) }
        invitedSelectionEvent!!.isInviteApprove = true
        invitedSelectionEvent = selectionEventRepository.save(invitedSelectionEvent)
        val creatorUsername = invitedSelectionEvent.creator.username
        val message = "User ${viewerUsername.username} has confirm your invite!"
        if (creatorUsername != null) {
            notificationService.notifyUser(creatorUsername, message)
        }
        return invitedSelectionEvent
    }
}