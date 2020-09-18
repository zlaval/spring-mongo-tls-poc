package com.zlrx.demo.mongotls.scheduled

import com.zlrx.demo.mongotls.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Reader @Autowired constructor(
    private val userRepository: UserRepository
) {


    private val logger = LoggerFactory.getLogger(javaClass)

    //@Scheduled(fixedDelay = 5000, initialDelay = 2000)
    fun readData() {
        val rows = userRepository.findAll()
        rows.collectList().block()?.forEach {
            logger.warn(it.toString())
        }

    }


}