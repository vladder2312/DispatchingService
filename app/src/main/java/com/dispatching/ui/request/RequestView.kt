package com.dispatching.ui.request

import com.arellomobile.mvp.MvpView
import com.dispatching.domain.Request

interface RequestView : MvpView {
    fun setRequest(request: Request)
    fun showSnackBar(message: String)
}