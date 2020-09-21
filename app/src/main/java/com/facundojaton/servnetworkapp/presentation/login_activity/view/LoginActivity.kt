package com.facundojaton.servnetworkapp.presentation.login_activity.view

import android.os.Bundle
import android.view.View
import com.facundojaton.servnetworkapp.R
import com.facundojaton.servnetworkapp.base.BaseActivity
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract
import com.facundojaton.servnetworkapp.presentation.login_activity.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter()
        presenter.attachView(this)

        btnLogin.setOnClickListener {
            login()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun activateWaitingMode() {
        pbLogin.visibility = View.VISIBLE
    }

    override fun deactivateWaitingMode() {
        pbLogin.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun login() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        if (presenter.checkEmptyFields(email, password)) {
            toast("Complete both fields")
        } else {
            presenter.signInUserWithEmailAndPassword(email, password)
        }
    }

    override fun navigateToMain() {
        TODO("Not yet implemented")
    }

    override fun navigateToRegister() {
        TODO("Not yet implemented")
    }

}