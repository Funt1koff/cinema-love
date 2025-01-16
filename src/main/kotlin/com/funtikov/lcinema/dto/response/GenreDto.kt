package com.funtikov.lcinema.dto.response

data class GenreDto(
    val title: String,
    val viewCount: Long,
    val favoriteAddedCount: Long,
    val viewedViewers: MutableList<PublicViewerDto>,
    val viewersFacorited: MutableList<PublicViewerDto>
)
