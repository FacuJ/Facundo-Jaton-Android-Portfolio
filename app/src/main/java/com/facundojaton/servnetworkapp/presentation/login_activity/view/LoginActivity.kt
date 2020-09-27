package com.facundojaton.servnetworkapp.presentation.login_activity.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.facundojaton.servnetworkapp.R
import com.facundojaton.servnetworkapp.base.BaseActivity
import com.facundojaton.servnetworkapp.domain.interactor.login_interactor.SignInInteractorImpl
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract
import com.facundojaton.servnetworkapp.presentation.login_activity.presenter.LoginPresenter
import com.facundojaton.servnetworkapp.presentation.main_activity.view.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(SignInInteractorImpl())
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
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun navigateToRegister() {
        //startActivity(Intent(this,RegisterActivity::class.java))
    }

}