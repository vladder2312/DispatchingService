package com.dispatching.domain

import java.io.Serializable
import java.util.*

data class Request(
    val id: String,
    val client: Client,
    val workers: List<Worker>,
    var type: Type,
    var price: Float,
    var description: String,
    val createDate: Date,
    val state: State
) : Serializable, Cloneable {

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

    override fun toString(): String {
        return "№$id: $type"
    }

    override fun clone(): Request {
        return Request(id, client, workers, type, price, description, createDate, state)
    }
}