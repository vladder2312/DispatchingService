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
            "",
            Date(121, 0, 13, 12, 30, 5),
            Request.State.PROCESSED
        ),
        Request(
            "124",
            Request.Type.ELECTRIC,
            Request.Address("Воронеж", "Космонавтов", 13, "2", 49),
            "89204123311",
            "Замена части проводки",
            Date(121, 1, 22, 16, 55, 12),
            Request.State.ACCEPTED
        )
    )
}