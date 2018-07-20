package com.goodjob

import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.util.Assert


@ExtendWith(SpringExtension::class)
@DataJpaTest
class StaffRepositoryTests(

        @Autowired private val staffRepository: StaffRepository) {

    @Test
    fun findByLastName() {
        val staff = staffRepository.findByLastName("zhijia")
        var list = Lists.newArrayList(staff)
        Assert.isTrue(1 == list.size, "has not fond")
    }
}