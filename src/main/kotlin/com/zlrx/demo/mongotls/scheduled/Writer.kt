package com.zlrx.demo.mongotls.scheduled

import com.zlrx.demo.mongotls.model.User
import com.zlrx.demo.mongotls.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicInteger

@Component
class Writer @Autowired constructor(
    private val userRepository: UserRepository
) {

    private val counter = AtomicInteger()

    @Scheduled(fixedDelay = 3000, initialDelay = 1000)
    fun writeDataToDb() {
        val user = User(name = "${counter.incrementAndGet()}")
        userRepository.save(user).block()
    }


}