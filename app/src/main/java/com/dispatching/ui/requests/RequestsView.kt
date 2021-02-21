package com.dispatching.ui.requests

import com.arellomobile.mvp.MvpView
import com.dispatching.domain.Request

interface RequestsView : MvpView {
    fun setData(requests: MutableList<Request>)
}