package com.dispatching.ui.requests

import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.dispatching.R
import com.dispatching.domain.Request
import org.w3c.dom.Text
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class RequestsController(
    private val onClickListener: (Request) -> Unit
) : BindableItemController<Request, RequestsController.RequestHolder>() {

    inner class RequestHolder(parent: ViewGroup) :
        BindableViewHolder<Request>(parent, R.layout.item_request) {
        private val card: CardView = itemView.findViewById(R.id.item_request_card)
        private val datetime: TextView = itemView.findViewById(R.id.item_request_datetime)
        private val name: TextView = itemView.findViewById(R.id.item_request_name)
        private val address: TextView = itemView.findViewById(R.id.item_request_address)
        private val state: TextView = itemView.findViewById(R.id.item_request_state)
        private lateinit var request: Request

        init {
            card.setOnClickListener { onClickListener(request) }
        }

        override fun bind(data: Request) {
            request = data
            datetime.text = data.createDate.toLocaleString()
            name.text = "№ ${data.id}: ${data.type}"
            address.text = data.client.address.toString()
            state.text = data.state.toString()
        }
    }

    override fun getItemId(req: Request) = req.id

    override fun createViewHolder(parent: ViewGroup) = RequestHolder(parent)
}