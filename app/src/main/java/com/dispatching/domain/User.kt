package com.dispatching.domain

import java.io.Serializable

open class User(
    open val id : String,
    open val fullName : String,
    open val phone : String,
    open val password : String
) : Serializable