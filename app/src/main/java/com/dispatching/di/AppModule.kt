package com.dispatching.di

import android.content.Context
import com.dispatching.data.TestData
import com.dispatching.ui.account.AccountFragment
import com.dispatching.ui.requests.RequestsFragment
import dagger.Module
import dagger.Provides

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
    fun provideTestData(): TestData {
        return TestData()
    }
}