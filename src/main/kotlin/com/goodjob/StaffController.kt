package com.goodjob

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class StaffController(@Autowired private val staffRepository: StaffRepository) {

    @GetMapping("/staffs")
    fun findAll() = staffRepository.findAll()

    @GetMapping("/staff")
    fun findByLastName(@RequestParam("lastName") lastName: String) = staffRepository.findByLastName(lastName)

    @GetMapping("/staff/age_gt/{age}")
    fun findByAgeGt(@PathVariable age: Int) = staffRepository.findByAgeGreaterThen(age)

}