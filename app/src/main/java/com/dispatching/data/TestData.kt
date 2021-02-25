package com.dispatching.data

import com.dispatching.domain.Client
import com.dispatching.domain.Request
import com.dispatching.domain.Worker
import io.reactivex.Observable
import java.util.*

class TestData {
    val requests = Observable.just(
        Request(
            "123",
            Client(
                "1",
                "Иванов Андрей Сергеевич",
                "89053441232",
                "ivanov1324"
            ),
            mutableListOf(
                Worker(
                    "32",
                    "Алексеев Антон Владимирович",
                    "89006553535",
                    "alskdj75",
                    Worker.Role.VERIFIER
                )
            ),
            Request.Type.CHECKING_COUNTERS,
            Request.Address("Воронеж", "20-летия Октября", 44, null, 12),
            "89512234455",
            1100.0f,
            "",
            Date(121, 0, 13, 12, 30, 5),
            Request.State.PROCESSED
        ),
        Request(
            "124",
            Client(
                "1",
                "Иванов Андрей Сергеевич",
                "89053441232",
                "ivanov1324"
            ),
            mutableListOf(
                Worker(
                    "32",
                    "Левин Максим Олегович",
                    "89006553535",
                    "mlevi3434",
                    Worker.Role.ELECTRICIAN
                ),
                Worker(
                    "33",
                    "Аксаков Сергей Витальевич",
                    "89506753434",
                    "axakser92",
                    Worker.Role.ELECTRICIAN
                )
            ),
            Request.Type.ELECTRIC,
            Request.Address("Воронеж", "Космонавтов", 13, "2", 49),
            "89204123311",
            2500.0f,
            "Замена части проводки",
            Date(121, 1, 22, 16, 55, 12),
            Request.State.ACCEPTED
        ),
        Request(
            "125",
            Client(
                "2",
                "Кузнецов Иван Анатольевич",
                "89515667483",
                "qwerty1928"
            ),
            mutableListOf(
                Worker(
                    "33",
                    "Ковальский Юрий Михайлович",
                    "89525633311",
                    "kovalsky545454",
                    Worker.Role.WELDER
                )
            ),
            Request.Type.WELDING,
            Request.Address("Воронеж", "Пушкина", 76, "у", 219),
            "89991232332",
            3700.0f,
            "Замена батареи в зале. Отменено заказчиком.",
            Date(121, 1, 25, 9, 12, 59),
            Request.State.CANCELED
        )
    )
}