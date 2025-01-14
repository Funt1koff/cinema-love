package com.funtikov.lcinema.entity

import jakarta.persistence.*

@Entity
@Table(name = "genre")
class Genre(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "genre_id_seq", sequenceName = "genre_id_seq", allocationSize = 1)
        var id: Long? = null,

        @Column(name = "title", nullable = false, unique = true)
        var title: String? = null,

        @Column(name = "view_count")
        var viewCount: Long? = 0,

        @Column(name = "favorite_added_count")
        var favoriteAddedCount: Long? = 0

)