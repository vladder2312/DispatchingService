package com.dispatching.ui.requests

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.dispatching.App
import com.dispatching.data.TestData
import com.dispatching.domain.Request
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class RequestsPresenter : MvpPresenter<RequestsView>() {

    @Inject
    lateinit var testData: TestData
    val model = RequestsModel()

    init {
        App.appComponent.inject(this)
    }

    fun loadRequests() {
        model.requests.clear()
        val disposable = testData.requests
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                model.requests.add(it)
                viewState.setData(model.requests)
            }
    }
}