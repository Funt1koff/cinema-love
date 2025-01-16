package com.funtikov.lcinema.repository

import com.funtikov.lcinema.entity.Cinema
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CinemaRepository : JpaRepository<Cinema, Long> {

}