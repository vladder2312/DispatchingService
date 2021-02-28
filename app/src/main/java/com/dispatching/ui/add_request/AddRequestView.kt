package com.dispatching.ui.add_request

import com.arellomobile.mvp.MvpView
import com.dispatching.domain.Client

interface AddRequestView : MvpView {
    fun setData(client: Client)
    fun finishView()
}