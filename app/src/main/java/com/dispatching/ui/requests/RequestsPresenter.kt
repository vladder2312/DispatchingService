package com.dispatching.ui.requests

import android.util.Log
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
        Log.d("MYLOG32", "Using: "+testData)
        val disposable = testData.getRequests()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                model.requests.add(it)
                viewState.setData(model.requests)
            }
    }
}