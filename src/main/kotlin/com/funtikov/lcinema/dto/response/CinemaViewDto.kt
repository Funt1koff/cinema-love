package com.funtikov.lcinema.dto.response

data class CinemaViewDto(
    val viewer: PublicViewerDto,
    val cinema: CinemaDto,
    val viewCount: Int,
)
