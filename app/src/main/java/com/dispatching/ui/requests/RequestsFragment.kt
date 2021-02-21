package com.dispatching.ui.requests

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Request
import com.dispatching.ui.request.RequestActivity
import kotlinx.android.synthetic.main.requests_fragment.*
import ru.surfstudio.android.easyadapter.EasyAdapter

class RequestsFragment : MvpAppCompatFragment(), RequestsView {

    @InjectPresenter
    lateinit var presenter: RequestsPresenter
    private val requestsAdapter = EasyAdapter()
    private val requestsController = RequestsController {
        startRequestActivity(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.requests_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        initListeners()
    }

    override fun setData(requests: MutableList<Request>) {
        requestsAdapter.setData(requests, requestsController)
        requests_swipe_refresh.isRefreshing = false
    }

    private fun initViews() {
        requests_recycler.layoutManager = GridLayoutManager(context, GridLayoutManager.VERTICAL)
        requests_recycler.adapter = requestsAdapter
        requests_swipe_refresh.isRefreshing = true
        presenter.loadRequests()
    }

    private fun initListeners() {
        requests_swipe_refresh.setOnRefreshListener {
            presenter.loadRequests()
        }
    }

    private fun startRequestActivity(request: Request) {
        val intent = Intent(context, RequestActivity::class.java)
        intent.putExtra("request", request)
        startActivity(intent)
    }
}