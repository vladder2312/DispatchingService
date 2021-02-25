package com.dispatching.data

import com.dispatching.domain.Request
import io.reactivex.Observable
import java.util.*

class TestData {
    val requests = Observable.just(
        Request(
            "123",
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