package com.dispatching.ui.add_request

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.get
import androidx.core.widget.addTextChangedListener
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Client
import com.dispatching.domain.Request
import kotlinx.android.synthetic.main.add_request_activity.*

class AddRequestActivity : MvpAppCompatActivity(), AddRequestView {

    @InjectPresenter
    lateinit var presenter: AddRequestPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_request_activity)

        initSpinner()
        initListeners()
        presenter.getData()
    }

    override fun setData(client: Client) {
        request_city.setText(client.address.city)
        request_street.setText(client.address.street)
        request_house.setText(client.address.house.toString())
        request_corpus.setText(client.address.corpus)
        request_room.setText(client.address.room.toString())
    }

    private fun initSpinner() {
        val adapter =
            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, Request.Type.values())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        request_type_spinner.adapter = adapter
    }

    private fun initListeners() {
        request_type_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
                presenter.typeChanged(parent.selectedItem as Request.Type)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        request_city.addTextChangedListener {
            presenter.addressChanged("city", it.toString())
        }
        request_street.addTextChangedListener {
            presenter.addressChanged("street", it.toString())
        }
        request_house.addTextChangedListener {
            presenter.addressChanged("house", it.toString())
        }
        request_corpus.addTextChangedListener {
            presenter.addressChanged("corpus", it.toString())
        }
        request_room.addTextChangedListener {
            presenter.addressChanged("room", it.toString())
        }
        request_description.addTextChangedListener {
            presenter.descriptionChanged(it.toString())
        }
        add_request_button.setOnClickListener {
            presenter.addButtonClicked()
        }
    }

    override fun finishView() {
        finish()
    }
}