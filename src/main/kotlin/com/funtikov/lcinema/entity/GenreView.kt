package com.funtikov.lcinema.entity

import jakarta.persistence.*

@Entity
@Table(name = "genre_view")
class GenreView(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_view_id_seq")
    @SequenceGenerator(name = "genre_view_id_seq", sequenceName = "genre_view_id_seq", allocationSize = 1)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "viewer_id", nullable = false)
    val viewer: Viewer,

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    val genre: Genre,

    @Column(name = "view_count", nullable = false)
    var viewCount: Int = 0,

    ) : Auditable()
