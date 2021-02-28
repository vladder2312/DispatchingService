package com.dispatching.ui.request

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.widget.addTextChangedListener
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Request
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.request_activity.*

class RequestActivity : MvpAppCompatActivity(), RequestView {

    @InjectPresenter
    lateinit var presenter: RequestPresenter
    private lateinit var doneItem: MenuItem
    private lateinit var editItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.request_activity)

        presenter.setRequest(intent.getStringExtra("request_id"))
        initListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.request_menu, menu)
        editItem = menu.getItem(0)
        doneItem = menu.getItem(1)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.request_edit_item -> {
                editMode(true)
            }
            R.id.request_edit_done -> {
                presenter.updateRequest()
                editMode(false)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setRequest(request: Request) {
        title = "Заявка №" + request.id
        request_datetime.text = request.createDate.toLocaleString()
        request_id_type.text = request.toString()
        request_address.text = request.client.address.toString()
        request_phone.setText(request.client.phone)
        request_price.setText(request.price.toString())
        request_workers.text =
            request.workers.joinToString(",\n", "", ".", -1, "") { it.toString() }
        request_description.setText(request.description)
        request_state.text = request.state.toString()
    }

    override fun showSnackBar(message: String) {
        Snackbar.make(request_address, message, Snackbar.LENGTH_SHORT)
    }

    private fun initListeners() {
        request_phone.addTextChangedListener {
            presenter.phoneChanged(it.toString())
        }
        request_price.addTextChangedListener {
            presenter.priceChanged(it.toString().toFloat())
        }
        request_description.addTextChangedListener {
            presenter.descriptionChanged(it.toString())
        }
    }

    private fun editMode(isOn: Boolean) {
        doneItem.isVisible = isOn
        editItem.isVisible = !isOn
        request_address.isEnabled = isOn
        request_phone.isEnabled = isOn
        request_price.isEnabled = isOn
        request_description.isEnabled = isOn
    }
}