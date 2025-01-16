package com.funtikov.lcinema.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "viewer")
class Viewer(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viewer_id_seq")
    @SequenceGenerator(name = "viewer_id_seq", sequenceName = "viewer_id_seq", allocationSize = 1)
    var id: Long? = null,

    @Column(name = "created", updatable = false)
    var created: LocalDateTime? = null,

    @Column(name = "modified")
    var modified: LocalDateTime? = null,

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

    // Many-to-Many for viewed genres
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
) {

    @PrePersist
    fun onCreate() {
        created = LocalDateTime.now()
        modified = LocalDateTime.now()
    }

    @PreUpdate
    fun onUpdate() {
        modified = LocalDateTime.now()
    }
}
