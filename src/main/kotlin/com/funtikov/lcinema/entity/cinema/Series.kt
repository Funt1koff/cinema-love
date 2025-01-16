package com.funtikov.lcinema.entity.cinema

import com.funtikov.lcinema.entity.MultipartCinema
import jakarta.persistence.*

@Entity
@Table(name = "series")
class Series(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "series_id_seq", sequenceName = "series_id_seq", allocationSize = 1)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "viewer_rating", nullable = false)
    var viewerRating: Double? = 0.0,

    @Column(name = "duration", nullable = false)
    var duration: Int? = 0,

    @ManyToOne
    @JoinColumn(name = "multipart_cinema_id")
    var serial: MultipartCinema? = null
)