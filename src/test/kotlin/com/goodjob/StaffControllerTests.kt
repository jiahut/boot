package com.goodjob

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class StaffControllerTests(
        @Autowired private val restTemplate: TestRestTemplate) {

    @Test
    fun findAll() {
        val content = """[{"firstName":"zhang","lastName":"zhijia","age":29,"id":1},{"firstName":"bei","lastName":"bei","age":28,"id":2}]"""
        assertEquals(content, restTemplate.getForObject<String>("/staffs"))
    }

}
