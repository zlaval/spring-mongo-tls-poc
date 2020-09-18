package com.zlrx.demo.mongotls.controller

import com.zlrx.demo.mongotls.model.User
import com.zlrx.demo.mongotls.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.util.concurrent.atomic.AtomicInteger

@RestController
@RequestMapping("/api/user")
class TestController @Autowired constructor(
    private val userRepository: UserRepository
) {

    private val counter = AtomicInteger()

    @GetMapping
    fun getUser(): Flux<User> {
        return userRepository.findAll()
    }


}