package com.funtikov.lcinema.entity

import jakarta.persistence.*
import java.time.LocalDateTime

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

    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {

    @PrePersist
    fun onCreate() {
        createdAt = LocalDateTime.now()
        updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    fun onUpdate() {
        updatedAt = LocalDateTime.now()
    }
}
