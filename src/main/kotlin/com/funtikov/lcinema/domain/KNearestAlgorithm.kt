package com.funtikov.lcinema.domain

import com.funtikov.lcinema.model.Cinema
import com.funtikov.lcinema.model.Viewer

class KNearestAlgorithm : RecomendationAlgorithm {

    override fun getRecomendation(viewer: Viewer, similarViewers: List<Viewer>, cinemaBatch: List<Cinema>): Cinema {
        val cinemaScores = mutableMapOf<Cinema, Double>()

        for (similarViewer in similarViewers) {
            val similarity = calculateSimilarity(viewer, similarViewer)

            for ((cinema, rating) in similarViewer.assessmentViewer) {
                if (cinema in cinemaBatch) {
                    cinemaScores[cinema] = cinemaScores.getOrDefault(cinema, 0.0) + similarity * rating
                }
            }
        }

        return cinemaScores.maxByOrNull { it.value }?.key
            ?: throw IllegalArgumentException("No suitable recommendation found")
    }

    private fun calculateSimilarity(viewer: Viewer, similarViewer: Viewer): Double {
        val viewerGenres = viewer.favoriteGenres.toSet()
        val similarViewerGenres = similarViewer.favoriteGenres.toSet()

        //Solve coefficient Jakkar
        val intersectionSize = viewerGenres.intersect(similarViewerGenres).size
        val unionSize = viewerGenres.union(similarViewerGenres).size

        return if (unionSize == 0) 0.0 else intersectionSize.toDouble()
    }

}