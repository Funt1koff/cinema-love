package com.funtikov.lcinema.repository

import com.funtikov.lcinema.model.Viewer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ViewerRepository : JpaRepository<Viewer, Long> {

}