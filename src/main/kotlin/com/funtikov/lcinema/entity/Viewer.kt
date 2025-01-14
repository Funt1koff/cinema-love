package com.funtikov.lcinema.entity

import jakarta.persistence.*
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "viewer")
class Viewer(

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "viewer_id_seq", sequenceName = "viewer_id_seq", allocationSize = 1)
        var id: Long? = null,

        @Column(name = "created", updatable = false, insertable = false)
        var create: LocalDateTime = LocalDateTime.now(),

        @Column(name = "modified")
        var modified: LocalDateTime = LocalDateTime.now(),

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

        @OneToMany(mappedBy = "viewer", cascade = [CascadeType.ALL], orphanRemoval = true)
        @Fetch(FetchMode.SUBSELECT)
        var genreViews: MutableList<GenreView> = mutableListOf(),

        @OneToMany(mappedBy = "viewer", cascade = [CascadeType.ALL], orphanRemoval = true)
        @Fetch(FetchMode.SUBSELECT)
        var genreFavorites: MutableList<Genre> = mutableListOf(),

        @OneToMany(mappedBy = "viewer", cascade = [CascadeType.ALL], orphanRemoval = true)
        @Fetch(FetchMode.SUBSELECT)
        var viewedCinemas: MutableList<CinemaView> = mutableListOf(),

        @OneToMany(mappedBy = "viewer", cascade = [CascadeType.ALL], orphanRemoval = true)
        @Fetch(FetchMode.SUBSELECT)
        var favoriteCinemas: MutableList<Cinema> = mutableListOf()


)