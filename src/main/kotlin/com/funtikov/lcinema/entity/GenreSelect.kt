package com.funtikov.lcinema.entity

import jakarta.persistence.*

@Entity
@Table(name = "genre_select")
class GenreSelect(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "genre_select_id_seq", sequenceName = "genre_select_id_seq", allocationSize = 1)
    val id: Long,

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE], fetch = FetchType.LAZY)
    @JoinColumn(name = "selection_event_id", referencedColumnName = "id")
    val selectionEvent: SelectionEvent,

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE], fetch = FetchType.LAZY)
    @JoinColumn(name = "respondent_id", referencedColumnName = "id")
    val respondent: Viewer,

    @ManyToOne(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinColumn(name = "selected_genre_id", referencedColumnName = "id")
    val selectedGenre: Genre,

    @ManyToOne(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinColumn(name = "rejected_genre_id", referencedColumnName = "id")
    val rejectedGenre: Genre,

) :Auditable()