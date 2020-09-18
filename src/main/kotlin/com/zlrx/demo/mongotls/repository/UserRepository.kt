package com.zlrx.demo.mongotls.repository

import com.zlrx.demo.mongotls.model.User
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepository : ReactiveMongoRepository<User, String> {
}