package com.funtikov.lcinema.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "viewer")
data class Viewer(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viewer_id_seq")
    @SequenceGenerator(name = "viewer_id_seq", sequenceName = "viewer_id_seq", allocationSize = 1)
    val id: Long? = null,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "middle_name")
    var middleName: String? = null,

    @Column(name = "age")
    var age: Byte? = null,

    @Column(name = "birth_date")
    var birthDate: LocalDate? = null,

    @Column(name = "email", unique = true)
    var email: String? = null,

    @ManyToMany
    @JoinTable(
        name = "viewer_genre_views",
        joinColumns = [JoinColumn(name = "viewer_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    var genreViews: MutableList<Genre> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "viewer_genre_favorites",
        joinColumns = [JoinColumn(name = "viewer_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")]
    )
    var genreFavorites: MutableList<Genre> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "viewer_viewed_cinemas",
        joinColumns = [JoinColumn(name = "viewer_id")],
        inverseJoinColumns = [JoinColumn(name = "cinema_id")]
    )
    var viewedCinemas: MutableList<Cinema> = mutableListOf(),

    @ManyToMany
    @JoinTable(
        name = "viewer_favorite_cinemas",
        joinColumns = [JoinColumn(name = "viewer_id")],
        inverseJoinColumns = [JoinColumn(name = "cinema_id")]
    )
    var favoriteCinemas: MutableList<Cinema> = mutableListOf()
) : Auditable()