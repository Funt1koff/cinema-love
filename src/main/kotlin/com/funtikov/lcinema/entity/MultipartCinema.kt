package com.funtikov.lcinema.entity

import com.funtikov.lcinema.entity.cinema.Series
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
abstract class MultipartCinema(
        var season: Int? = 1,

        @OneToMany(mappedBy = "serial", targetEntity = Series::class)
        var series: MutableList<Series> = mutableListOf(),
) : Cinema()