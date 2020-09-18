package com.zlrx.demo.mongotls.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    val _id: String? = null,
    val name: String
)