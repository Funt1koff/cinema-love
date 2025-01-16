package com.funtikov.lcinema.entity

import com.funtikov.lcinema.entity.cinema.Series
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany

@Entity
abstract class MultipartCinema(

    var season: Int? = 1,

    @OneToMany(mappedBy = "serial", cascade = [CascadeType.ALL], orphanRemoval = true)
    var series: MutableList<Series> = mutableListOf()
) : Cinema()
