package com.dispatching.domain

import java.io.Serializable

data class Client(
    override val id: String,
    override val fullName: String,
    override var phone: String,
    override val password: String,
    val address: Address
) : User(id, fullName, phone, password), Serializable {

    data class Address(
        val city: String,
        val street: String,
        val house: Int,
        val corpus: String?,
        val room: Int
    ) : Serializable {
        override fun toString(): String {
            var text = "$city, ул. $street, д. $house"
            if (corpus != null) text += "/$corpus"
            text += ", кв. $room"
            return text
        }
    }
}