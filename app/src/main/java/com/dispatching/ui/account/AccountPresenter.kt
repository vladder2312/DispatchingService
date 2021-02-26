package com.dispatching.ui.account

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.dispatching.App
import com.dispatching.data.TestData
import com.dispatching.domain.Client
import com.dispatching.domain.User
import javax.inject.Inject

@InjectViewState
class AccountPresenter : MvpPresenter<AccountView>() {

    @Inject
    lateinit var user: User
    val model = AccountModel()

    init {
        App.appComponent.inject(this)
    }

    fun loadUser() {
        viewState.setUser(user)
    }
}