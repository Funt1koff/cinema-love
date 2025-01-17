package com.funtikov.lcinema.repository

import com.funtikov.lcinema.entity.CinemaType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CinemaTypeRepository : JpaRepository<CinemaType, Long>