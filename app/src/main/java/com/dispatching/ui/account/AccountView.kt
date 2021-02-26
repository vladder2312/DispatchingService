package com.dispatching.ui.account

import com.arellomobile.mvp.MvpView
import com.dispatching.domain.User

interface AccountView : MvpView {
    fun setUser(user : User)
}