package com.dispatching.ui.request

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Request
import kotlinx.android.synthetic.main.request_activity.*

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
        request_datetime.text = request.createDate.toLocaleString()
        request_id_type.text = request.toString()
        request_address.text = request.address.toString()
        request_phone.text = request.phone
        request_price.text = request.price.toString()
        request_description.text = request.description
        request_state.text = request.state.toString()
    }
}