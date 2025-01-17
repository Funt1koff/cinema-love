package com.funtikov.lcinema.entity

import jakarta.persistence.*

@Entity
@Table(name = "cinema_type")
class CinemaType (

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cinema_type_id_seq", sequenceName = "cinema_type_id_seq", allocationSize = 1)
    val id: Long,

    @Column(updatable = false)
    val name: String,

) : Auditable()