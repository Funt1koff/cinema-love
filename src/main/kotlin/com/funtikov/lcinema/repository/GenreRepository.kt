package com.funtikov.lcinema.repository

import com.funtikov.lcinema.entity.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : JpaRepository<Genre, Long> {
}