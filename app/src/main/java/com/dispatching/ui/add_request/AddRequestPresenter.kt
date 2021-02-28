package com.dispatching.ui.add_request

import android.os.Build
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dispatching.App
import com.dispatching.data.TestData
import com.dispatching.domain.Client
import com.dispatching.domain.Request
import com.dispatching.domain.User
import java.time.Instant
import java.util.*
import javax.inject.Inject

@InjectViewState
class AddRequestPresenter : MvpPresenter<AddRequestView>() {

    @Inject
    lateinit var testData: TestData

    @Inject
    lateinit var user: User

    val model = AddRequestModel()

    init {
        App.appComponent.inject(this)
    }

    fun getData() {
        viewState.setData(user as Client)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            model.request = Request(
                System.currentTimeMillis().toString(),
                user as Client,
                mutableListOf(),
                Request.Type.ELECTRIC,
                0.0f,
                "",
                Date.from(Instant.now()),
                Request.State.PROCESSED
            )
        }
    }

    fun typeChanged(type: Request.Type) {
        model.request.type = type
    }

    fun addressChanged(field: String, value: String) {
        model.request::class.java.fields.find {
            it.name == field
        }?.set(value, value)
    }

    fun descriptionChanged(text: String) {
        model.request.description = text
    }

    fun addButtonClicked() {
        testData.addRequest(model.request)
        viewState.finishView()
    }
}