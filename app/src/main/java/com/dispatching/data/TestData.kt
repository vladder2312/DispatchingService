package com.dispatching.data

import com.dispatching.domain.Client
import com.dispatching.domain.Request
import com.dispatching.domain.User
import com.dispatching.domain.Worker
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*

class TestData {

    val users = arrayListOf(
        Client(
            "0",
            "Иванов Андрей Сергеевич",
            "89053441232",
            "ivanov1324",
            Client.Address(
                "Воронеж",
                "20-летия Октября",
                44,
                null,
                12
            )
        ),
        Client(
            "1",
            "Иванов Андрей Сергеевич",
            "89053441232",
            "ivanov1324",
            Client.Address(
                "Воронеж",
                "Космонавтов",
                13,
                "2",
                49
            )
        ),
        Client(
            "2",
            "Кузнецов Иван Анатольевич",
            "89515667483",
            "qwerty1928",
            Client.Address(
                "Воронеж",
                "Пушкина",
                76,
                "у",
                219
            )
        ),

        Worker(
            "3",
            "Алексеев Антон Владимирович",
            "89006553535",
            "alskdj75",
            Worker.Role.VERIFIER
        ),
        Worker(
            "4",
            "Левин Максим Олегович",
            "89006553535",
            "mlevi3434",
            Worker.Role.ELECTRICIAN
        ),
        Worker(
            "5",
            "Аксаков Сергей Витальевич",
            "89506753434",
            "axakser92",
            Worker.Role.ELECTRICIAN
        ),
        Worker(
            "6",
            "Ковальский Юрий Михайлович",
            "89525633311",
            "kovalsky545454",
            Worker.Role.WELDER
        )
    )

    val requests = arrayListOf(
        Request(
            "123",
            users[0] as Client,
            mutableListOf(
                users[3] as Worker
            ),
            Request.Type.CHECKING_COUNTERS,
            1100.0f,
            "",
            Date(121, 0, 13, 12, 30, 5),
            Request.State.PROCESSED
        ),
        Request(
            "124",
            users[1] as Client,
            mutableListOf(
                users[4] as Worker,
                users[5] as Worker
            ),
            Request.Type.ELECTRIC,
            2500.0f,
            "Замена части проводки",
            Date(121, 1, 22, 16, 55, 12),
            Request.State.ACCEPTED
        ),
        Request(
            "125",
            users[2] as Client,
            mutableListOf(
                users[6] as Worker
            ),
            Request.Type.WELDING,
            3700.0f,
            "Замена батареи в зале. Отменено заказчиком.",
            Date(121, 1, 25, 9, 12, 59),
            Request.State.CANCELED
        )
    )

    fun getRequests() = Observable.fromIterable(requests)

    fun getWorkers() = Observable.fromIterable(users.filter { it is Worker })

    fun getClient(id: String) = Single.just(
        users.filter { it is Client }
            .find { it.id == id } as Client
    )

    fun getWorker(id: String) = Single.just(
        users.filter { it is Worker }
            .find { it.id == id } as Worker
    )

    fun getRequest(id: String) = Single.just(
        requests.find { it.id == id }
    )

    fun editClient(client: Client) {
        for (i in 0 until users.size) {
            if (users[i].id == client.id) {
                users[i] = client
            }
        }
    }

    fun editRequest(request: Request) {
        for (i in 0 until requests.size) {
            if (requests[i].id == request.id) {
                requests[i] = request
            }
        }
    }

    fun addRequest(request: Request) {
        requests.add(request)
    }
}