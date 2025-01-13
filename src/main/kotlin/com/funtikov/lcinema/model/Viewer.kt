package com.funtikov.lcinema.model

abstract class Viewer {

    abstract var topViewedGenres: Map<Genre, Int>
    abstract var favoriteGenres: List<Genre>

    abstract var topViewedCinemas: Map<Cinema, Int>
    abstract var favoriteCinemas: List<Cinema>

    abstract var assessmentViewer: Map<Cinema, Byte>

}