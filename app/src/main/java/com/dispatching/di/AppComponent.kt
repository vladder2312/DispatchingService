package com.dispatching.di

import android.content.Context
import com.dispatching.data.TestData
import com.dispatching.domain.User
import com.dispatching.ui.account.AccountFragment
import com.dispatching.ui.account.AccountPresenter
import com.dispatching.ui.main.MainActivity
import com.dispatching.ui.request.RequestPresenter
import com.dispatching.ui.requests.RequestsFragment
import com.dispatching.ui.requests.RequestsPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun provideContext(): Context
    fun provideRequestsFragment(): RequestsFragment
    fun provideAccountFragment(): AccountFragment
    fun provideTestData(): TestData
    fun provideAccount(): User

    fun inject(mainActivity: MainActivity)
    fun inject(requestsPresenter: RequestsPresenter)
    fun inject(accountPresenter: AccountPresenter)
    fun inject(requestPresenter: RequestPresenter)
}