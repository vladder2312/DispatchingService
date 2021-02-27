package com.dispatching.ui.request

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dispatching.App
import com.dispatching.data.TestData
import com.dispatching.domain.Request
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class RequestPresenter : MvpPresenter<RequestView>() {

    @Inject
    lateinit var testData: TestData
    val model = RequestModel()

    init {
        App.appComponent.inject(this)
    }

    fun updateRequest(req: Request) {
        model.request = req
        testData.editRequest(req)
    }

    fun setRequest(req_id: String) {
        val disposable = testData.getRequest(req_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                if (it != null) {
                    model.request = it
                    viewState.setRequest(it)
                }
            }
    }

    fun phoneChanged(phone: String) {
        model.request.client.phone = phone
    }

    fun priceChanged(price: Float) {
        model.request.price = price
    }

    fun descriptionChanged(description: String) {
        model.request.description = description
    }
}