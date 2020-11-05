package com.facundojaton.servnetworkapp.presentation.registration_activity.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.facundojaton.servnetworkapp.R
import com.facundojaton.servnetworkapp.base.BaseActivity
import com.facundojaton.servnetworkapp.presentation.main_activity.view.MainActivity
import com.facundojaton.servnetworkapp.presentation.registration_activity.RegisterContract
import com.facundojaton.servnetworkapp.presentation.registration_activity.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterContract.RegisterView {

    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = RegisterPresenter()
        presenter.attachView(this)
    }

    override fun getLayout(): Int {
        return R.layout.activity_register
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun signUp() {

    }

    override fun showProgress() {
        pbRegister?.visibility = View.VISIBLE
        btnRegister.isEnabled = false
    }

    override fun hideProgress() {
        pbRegister?.visibility = View.GONE
        btnRegister.isEnabled = true
    }

    override fun showError(errorMessage: String) {
        toast(errorMessage)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}