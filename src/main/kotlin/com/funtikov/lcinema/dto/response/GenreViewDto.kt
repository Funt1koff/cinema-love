package com.funtikov.lcinema.dto.response

data class GenreViewDto(
    val viewer: PublicViewerDto,
    val genre: GenreDto,
    val viewedCount: Int,
)
