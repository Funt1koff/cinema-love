package com.funtikov.lcinema.domain

import com.funtikov.lcinema.model.Cinema
import com.funtikov.lcinema.model.Viewer

interface RecomendationAlgorithm {

    fun getRecomendation(viewer: Viewer, similarViewers: List<Viewer>, cinemaBatch: List<Cinema>): Cinema

}