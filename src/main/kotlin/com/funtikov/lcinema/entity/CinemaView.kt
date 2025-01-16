package com.funtikov.lcinema.entity

import jakarta.persistence.*

@Entity
@Table(name = "cinema_view")
class CinemaView(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cinema_view_id_seq", sequenceName = "cinema_view_id_seq", allocationSize = 1)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "viewer_id", nullable = false)
    val viewer: Viewer,

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    val cinema: Cinema,

    @Column(name = "view_count")
    val viewCount: Int? = 0,
)