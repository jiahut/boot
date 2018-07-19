package com.goodjob

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BootApplication {

    private val log = LoggerFactory.getLogger(BootApplication::class.java)


    @Bean
    fun init(repo: StaffRepository) = CommandLineRunner {
        log.info(" insert 2 staff ")
        repo.save(Staff("zhang", "zhijia", 29))
        repo.save(Staff("bei", "bei", 28))

        log.debug("fetch all")
        repo.findAll().forEach {log.info(it.toString())}

        val zhijia = repo.findById(1)
        zhijia.ifPresent {
            log.debug(" found the staff with findById(1) ")
            log.info(it.toString())
        }

        log.debug("use findByLastname ")
        val bei = repo.findByLastName("bei")
        bei.forEach {
            log.debug("find by lastName")
            log.info(it.toString())
        }
        log.debug("done.")
    }
}

fun main(args: Array<String>) {
    runApplication<BootApplication>(*args)
}
