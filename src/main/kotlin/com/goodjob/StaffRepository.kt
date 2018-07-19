package com.goodjob

import org.springframework.data.repository.CrudRepository

interface StaffRepository : CrudRepository<Staff, Long> {
    fun findByLastName(lastName: String): Iterable<Staff>
}