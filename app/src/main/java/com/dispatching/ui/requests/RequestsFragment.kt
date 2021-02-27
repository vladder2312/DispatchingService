package com.dispatching.ui.requests

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Request
import com.dispatching.ui.add_request.AddRequestActivity
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.requests_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_request_item -> {
                startAddRequestAcitivity()
            }
        }
        return super.onOptionsItemSelected(item)
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
        activity?.title = resources.getString(R.string.title_requests)
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
        intent.putExtra("request_id", request.id)
        startActivity(intent)
    }

    private fun startAddRequestAcitivity() {
        val intent = Intent(context, AddRequestActivity::class.java)
        startActivity(intent)
    }
}