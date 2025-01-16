package com.funtikov.lcinema.entity

import jakarta.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Cinema(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cinema_id_seq", sequenceName = "cinema_id_seq", allocationSize = 1)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String? = null,

    @Column(name = "description", nullable = false)
    var description: String? = null,

    @Column(name = "release_date", nullable = false, updatable = false)
    var releaseDate: Int? = null,

    @Column(name = "avg_duration", nullable = false, updatable = false)
    var avgDurationInSec: Int? = null,

    @Column(name = "rating", nullable = false)
    var rating: Double? = null,

    @JoinTable(
        name = "cinema_genre",
        joinColumns = [JoinColumn(name = "cinema_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    var tags: MutableList<Genre>? = mutableListOf()
)