package com.dispatching.ui.request

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Request

class RequestActivity : MvpAppCompatActivity(), RequestView {

    @InjectPresenter
    lateinit var presenter: RequestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_activity)

        initViews()
    }

    private fun initViews() {
        val request: Request = intent.getSerializableExtra("request") as Request
        title = "№" + request.id + ": " + request.type
    }
}