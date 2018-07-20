package com.goodjob

import org.assertj.core.util.Lists
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.util.Assert


@ExtendWith(SpringExtension::class)
@SpringBootTest
class MockAndSpyTests {
    @Autowired
    private lateinit var staffController: StaffController
    @MockBean
    private lateinit var staffRepository: StaffRepository

    @Test
    fun test01() {

        val staff = Staff("my", "baby", 1)
        var list = Lists.newArrayList<Staff>(staff)
        given(staffRepository.findByAgeGreaterThen(ArgumentMatchers.anyInt())).willReturn(list)
        staffController.findByAgeGt(100)
        Assert.isTrue(staffController.findByAgeGt(100) == staffRepository.findByAgeGreaterThen(1),
                "should equals")
    }

}