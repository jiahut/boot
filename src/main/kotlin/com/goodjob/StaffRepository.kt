package com.goodjob

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface StaffRepository : CrudRepository<Staff, Long> {
    fun findByLastName(lastName: String): Iterable<Staff>
    @Query("select firstName,lastName,age,id  from Staff s where s.age > ?1")
    fun findByAgeGreaterThen(age: Int): Iterable<Staff>
}