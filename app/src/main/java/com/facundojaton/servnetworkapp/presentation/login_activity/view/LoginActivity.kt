package com.facundojaton.servnetworkapp.presentation.login_activity.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facundojaton.servnetworkapp.R
import com.facundojaton.servnetworkapp.base.BaseActivity
import com.facundojaton.servnetworkapp.domain.interactor.LoginInteractor
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract
import com.facundojaton.servnetworkapp.presentation.login_activity.presenter.LoginPresenter

class LoginActivity : BaseActivity<LoginPresenter>(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun waitingMode(isWaiting: Boolean) {
        TODO("Not yet implemented")
    }

    override fun createPresenter(context: Context): LoginPresenter {
        return LoginPresenter(this, LoginInteractor())
    }
}