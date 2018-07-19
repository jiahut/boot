package com.goodjob

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Staff(
        val firstName: String,
        val lastName: String,
        val age: Int,
        @Id
        @GeneratedValue
        val id: Long = -1)
