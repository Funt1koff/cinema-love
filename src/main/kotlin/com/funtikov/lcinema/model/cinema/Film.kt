package com.funtikov.lcinema.model.cinema

import com.funtikov.lcinema.model.Cinema
import com.funtikov.lcinema.model.Genre

class Film(
    override val title: String,
    override val description: String,
    override val releaseYear: Int,
    override var rating: Byte,
    override var tags: List<Genre>,
    override var genre: String,
    override var ratingImdb: Double,
    override var metadata: Map<String, String>,
    override var avgDuration: Double,
) : Cinema() {

}