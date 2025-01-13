package com.funtikov.lcinema.model

abstract class Cinema {

    abstract val title: String
    abstract val description: String
    abstract val releaseYear: Int
    abstract var rating: Byte
    abstract var tags: List<Genre>
    abstract var genre: String
    abstract var ratingImdb: Double
    abstract var avgDuration: Double

    abstract var metadata: Map<String, String>

}