package com.funtikov.lcinema.dto.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class PublicViewerDto (
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val nickName: String,
    val age: Byte,
    val genreViews: MutableList<GenreViewDto>,
    val viewedCinemas: MutableList<CinemaViewDto>,
    val favoriteCinemas: MutableList<CinemaDto>,
    val favoriteGenres: MutableList<GenreDto>
)