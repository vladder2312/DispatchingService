package com.dispatching.domain

import java.io.Serializable

data class Client(
    override val id: String,
    override val fullName: String,
    override val phone: String,
    override val password: String
) : User(id, fullName, phone, password), Serializable