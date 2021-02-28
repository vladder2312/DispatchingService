package com.dispatching.ui.requests

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Request
import com.dispatching.ui.add_request.AddRequestActivity
import com.dispatching.ui.request.RequestActivity
import com.google.android.material.tabs.TabLayoutMediator
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
                startAddRequestActivity()
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

        requests_pager.adapter = RequestsPagerAdapter(requestsAdapter)
        requests_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                presenter.pageSelected(position)
            }
        })
        TabLayoutMediator(
            requests_tabs,
            requests_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = resources.getStringArray(R.array.states)[position]
            }
        ).attach()
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

    private fun startAddRequestActivity() {
        val intent = Intent(context, AddRequestActivity::class.java)
        startActivity(intent)
    }
}