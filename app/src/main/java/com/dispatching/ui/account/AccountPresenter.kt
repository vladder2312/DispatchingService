package com.dispatching.ui.account

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

@InjectViewState
class AccountPresenter : MvpPresenter<MvpView>() {

    val model = AccountModel()
}