package com.dispatching.domain

import java.io.Serializable

data class Worker(
    override val id: String,
    override val fullName: String,
    override val phone: String,
    override val password: String,
    val role : Role
) : User(id, fullName, phone, password), Serializable {

    enum class Role {
        PLUMBER {
            override fun toString(): String {
                return "Сантехник"
            }
        },
        ELECTRICIAN {
            override fun toString(): String {
                return "Электрик"
            }
        },
        WELDER {
            override fun toString(): String {
                return "Сварщик"
            }
        },
        VERIFIER {
            override fun toString(): String {
                return "Поверщик"
            }
        },
        INSTALLER {
            override fun toString(): String {
                return "Монтёр"
            }
        }
    }

    override fun toString(): String {
        return fullName+" ("+role+")"
    }
}