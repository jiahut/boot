package com.goodjob

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam

@RestController
class StaffController(private val staffRepository: StaffRepository) {

    @GetMapping("/staffs")
    fun findAll() = staffRepository.findAll()

    @GetMapping("/staff/{lastName}")
    fun findByLastName(@PathVariable lastName: String) = staffRepository.findByLastName(lastName)

}