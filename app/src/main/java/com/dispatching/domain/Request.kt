package com.dispatching.domain

import java.io.Serializable
import java.util.*

data class Request(
    val id: String,
    val client: Client,
    val workers: List<Worker>,
    val type: Type,
    val address: Address,
    val phone: String,
    val price: Float,
    val description: String,
    val createDate: Date,
    val state: State
) : Serializable {

    enum class Type : Serializable {
        ELECTRIC {
            override fun toString() = "Электрика"
        },
        PLUMBING {
            override fun toString() = "Сантехника"
        },
        REPAIRING {
            override fun toString() = "Ремонт"
        },
        WELDING {
            override fun toString() = "Сварочные работы"
        },
        MOUNTING {
            override fun toString() = "Установка оборудования"
        },
        DEMOUNTING {
            override fun toString() = "Демонтаж оборудования"
        },
        CHECKING_COUNTERS {
            override fun toString() = "Поверка счётчиков"
        }
    }

    enum class State : Serializable {
        PROCESSED {
            override fun toString() = "Обрабатывается"
        },
        ACCEPTED {
            override fun toString() = "Принято"
        },
        CANCELED {
            override fun toString() = "Отколонено"
        },
        DONE {
            override fun toString() = "Готово"
        }
    }

    data class Address(
        val city: String,
        val street: String,
        val house: Int,
        val corpus: String?,
        val room: Int
    ) : Serializable {
        override fun toString(): String {
            var text = "$city, ул. $street, д. $house, "
            if (corpus != null) text += "к. $corpus, "
            text += "кв. $room"
            return text
        }
    }

    override fun toString(): String {
        return "№$id: $type"
    }
}