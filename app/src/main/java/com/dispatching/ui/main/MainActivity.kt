package com.dispatching.ui.main

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.dispatching.App
import com.dispatching.R
import com.dispatching.ui.account.AccountFragment
import com.dispatching.ui.requests.RequestsFragment
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var requestsFragment: RequestsFragment

    @Inject
    lateinit var accountFragment: AccountFragment

    init {
        App.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        initViews()
        initListeners()
    }

    private fun initViews() {
        supportFragmentManager.beginTransaction().add(R.id.fragment_holder, requestsFragment)
            .commit()
    }

    private fun initListeners() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.action_requests -> {
                    transaction.replace(R.id.fragment_holder, requestsFragment)
                    it.isChecked = true
                }
                R.id.action_account -> {
                    transaction.replace(R.id.fragment_holder, accountFragment)
                    it.isChecked = true
                }
            }
            transaction.commit()
            false
        }
    }
}