package com.funtikov.lcinema.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "selection_event")
data class SelectionEvent(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "selection_event_id_seq", sequenceName = "selection_event_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "event_id", nullable = false, insertable = false, length = 32, unique = true)
    val eventId: String = UUID.randomUUID().toString().replace("-", ""),

    @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    val creator: Viewer,

    @ManyToOne(cascade = [CascadeType.MERGE, CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "invited_viewer_id", referencedColumnName = "id")
    val invitedViewer: Viewer,

    @ManyToOne(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    val matchedCinema: Cinema,

    @Column(name = "is_success")
    val isSuccess: Boolean = false,

    @Enumerated(EnumType.STRING)
    @Column(name = "fail_event_reason")
    val failEventReason: FailEventReason? = null,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "selection_event_genres",
        joinColumns = [JoinColumn(name = "selection_event_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    val genreSelects: MutableList<GenreSelect> = mutableListOf()
) : Auditable()