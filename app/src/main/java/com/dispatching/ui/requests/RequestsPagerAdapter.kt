package com.dispatching.ui.requests

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dispatching.R
import kotlinx.android.synthetic.main.page_requests.view.*
import ru.surfstudio.android.easyadapter.EasyAdapter

class RequestsPagerAdapter(
    private val adapter: EasyAdapter
) : RecyclerView.Adapter<RequestsPagerAdapter.PagerViewHolder>() {

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.page_requests, parent, false)
    )

    override fun getItemCount() = 3

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) = holder.itemView.run {
        requests_recycler.layoutManager = LinearLayoutManager(context)
        requests_recycler.adapter = adapter
    }
}