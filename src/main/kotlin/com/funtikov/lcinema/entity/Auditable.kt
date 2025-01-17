package com.funtikov.lcinema.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class Auditable {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDate: LocalDateTime? = null

    @LastModifiedDate
    @Column(nullable = false)
    var modifiedDate: LocalDateTime? = null

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 64)
    var createdBy: String? = null

    @LastModifiedBy
    @Column(nullable = false, length = 64)
    var modifiedBy: String? = null

}