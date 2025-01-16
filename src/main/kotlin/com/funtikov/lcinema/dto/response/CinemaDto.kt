package com.funtikov.lcinema.dto.response

data class CinemaDto(
    val title: String,
    val description: String,
    val releaseYear: Int,
    val ratingImdb: Double,
    val avgDurationInSec: Int,
    val tags: MutableList<GenreDto>
)
