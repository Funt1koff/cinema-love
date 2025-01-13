package com.funtikov.lcinema.domain

import com.funtikov.lcinema.model.Cinema
import com.funtikov.lcinema.model.Genre
import com.funtikov.lcinema.model.Viewer
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class KNearestAlgorithmTest {

    private val algorithm = KNearestAlgorithm()

    @Test
    fun `should recommend the highest rated cinema from similar viewers`() {  // Подготовка данных
        val genreAction = object : Genre() {
            override var title = "Action"
            override var code = 1
            override var metadata = emptyMap<String, String>()
        }

        val cinema1 = object : Cinema() {
            override val title = "Action Movie 1"
            override val description = "Exciting action movie."
            override val releaseYear = 2020
            override var rating: Byte = 8
            override var tags: List<Genre> = listOf(genreAction)
            override var genre = "Action"
            override var ratingImdb = 7.5
            override var avgDuration = 120.0
            override var metadata = emptyMap<String, String>()
        }

        val cinema2 = object : Cinema() {
            override val title = "Action Movie 2"
            override val description = "Another exciting action movie."
            override val releaseYear = 2021
            override var rating: Byte = 9
            override var tags: List<Genre> = listOf(genreAction)
            override var genre = "Action"
            override var ratingImdb = 8.0
            override var avgDuration = 130.0
            override var metadata = emptyMap<String, String>()
        }

        val viewer = object : Viewer() {
            override var topViewedGenres: Map<Genre, Int> = mapOf(genreAction to 10)
            override var favoriteGenres: List<Genre> = listOf(genreAction)
            override var topViewedCinemas: Map<Cinema, Int> = mapOf(cinema1 to 5)
            override var favoriteCinemas: List<Cinema> = listOf(cinema1)
            override var assessmentViewer = emptyMap<Cinema, Byte>()
        }

        val similarViewer = object : Viewer() {
            override var topViewedGenres: Map<Genre, Int> = mapOf(genreAction to 8)
            override var favoriteGenres: List<Genre> = listOf(genreAction)
            override var topViewedCinemas = mapOf(cinema1 to 7, cinema2 to 5)
            override var favoriteCinemas: List<Cinema> = listOf(cinema2)
            override var assessmentViewer: Map<Cinema, Byte> = mapOf(cinema1 to 7, cinema2 to 10)
        }

        val recommendedCinema = algorithm.getRecomendation(viewer, listOf(similarViewer), listOf(cinema1, cinema2))

        assertEquals(cinema2.title, recommendedCinema.title)
    }

    @Test
    fun `should throw exception when no suitable recommendation found`() {

        val viewer = object : Viewer() {
            override var topViewedGenres = emptyMap<Genre, Int>()
            override var favoriteGenres = emptyList<Genre>()
            override var topViewedCinemas = emptyMap<Cinema, Int>()
            override var favoriteCinemas = emptyList<Cinema>()
            override var assessmentViewer = emptyMap<Cinema, Byte>()
        }

        val similarViewer = object : Viewer() {
            override var topViewedGenres = emptyMap<Genre, Int>()
            override var favoriteGenres = emptyList<Genre>()
            override var topViewedCinemas = emptyMap<Cinema, Int>()
            override var favoriteCinemas = emptyList<Cinema>()
            override var assessmentViewer = emptyMap<Cinema, Byte>()
        }

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            algorithm.getRecomendation(viewer, listOf(similarViewer), emptyList())
        }

        assertEquals("No suitable recommendation found", exception.message)
    }
}