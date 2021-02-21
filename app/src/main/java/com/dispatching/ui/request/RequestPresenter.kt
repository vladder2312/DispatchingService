package com.dispatching.ui.request

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class RequestPresenter : MvpPresenter<RequestView>() {

    val model = RequestModel()
}