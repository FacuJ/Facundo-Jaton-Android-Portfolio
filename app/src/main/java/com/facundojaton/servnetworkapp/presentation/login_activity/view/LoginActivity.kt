package com.facundojaton.servnetworkapp.presentation.login_activity.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.facundojaton.servnetworkapp.R
import com.facundojaton.servnetworkapp.base.BaseActivity
import com.facundojaton.servnetworkapp.domain.interactor.LoginInteractor
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract
import com.facundojaton.servnetworkapp.presentation.login_activity.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        toast("Login apretado")
    }

}