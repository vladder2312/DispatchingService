package com.dispatching.di

import android.accounts.Account
import android.content.Context
import android.util.Log
import com.dispatching.data.TestData
import com.dispatching.domain.User
import com.dispatching.ui.account.AccountFragment
import com.dispatching.ui.requests.RequestsFragment
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideRequestsFragment(): RequestsFragment {
        return RequestsFragment()
    }

    @Provides
    fun provideAccountFragment(): AccountFragment {
        return AccountFragment()
    }

    @Provides
    @Singleton
    fun provideTestData(): TestData {
        return TestData()
    }

    @Provides
    @Singleton
    fun provideAccount(): User {
        return provideTestData().users[0]
    }
}