package com.dispatching.ui.account

import android.opengl.Visibility
import android.os.Bundle
import android.view.*
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.dispatching.R
import com.dispatching.domain.Client
import com.dispatching.domain.User
import com.dispatching.domain.Worker
import kotlinx.android.synthetic.main.account_fragment.*

class AccountFragment : MvpAppCompatFragment(), AccountView {

    @InjectPresenter
    lateinit var presenter: AccountPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        presenter.loadUser()
        return inflater.inflate(R.layout.account_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.account_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun setUser(user : User) {
        acc_login.text = user.phone
        acc_fullname.text = user.fullName
        if (user is Client) {
            acc_address_label.visibility = View.VISIBLE
            acc_address.visibility = View.VISIBLE
            acc_address.text = user.address.toString()
            activity?.title = resources.getString(R.string.profile)
        } else {
            activity?.title = (user as Worker).role.toString()
        }
    }
}