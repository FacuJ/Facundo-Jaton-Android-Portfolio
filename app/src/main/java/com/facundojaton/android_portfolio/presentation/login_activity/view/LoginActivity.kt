package com.facundojaton.android_portfolio.presentation.login_activity.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.facundojaton.android_portfolio.base.BaseActivity
import com.facundojaton.android_portfolio.databinding.ActivityLoginBinding
import com.facundojaton.android_portfolio.domain.interactor.login_interactor.SignInInteractorImpl
import com.facundojaton.android_portfolio.presentation.login_activity.LoginContract
import com.facundojaton.android_portfolio.presentation.login_activity.presenter.LoginPresenter
import com.facundojaton.android_portfolio.presentation.main_activity.view.MainActivity
import com.facundojaton.android_portfolio.presentation.registration_activity.view.RegisterActivity

class LoginActivity : BaseActivity(), LoginContract.View {

    private lateinit var presenter: LoginPresenter
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        presenter = LoginPresenter(SignInInteractorImpl())
        presenter.attachView(this)

        binding.apply {
            setContentView(root)
            btnLogin.setOnClickListener {
                login()
            }
            btnLoginNewAccount.setOnClickListener {
                navigateToRegister()
            }
        }
    }

    override fun activateWaitingMode() {
        binding.pbLogin.visibility = View.VISIBLE
    }

    override fun deactivateWaitingMode() {
        binding.pbLogin.visibility = View.GONE
    }

    override fun showMessage(message: String?) {
        message?.let { toast(it) }
    }

    override fun login() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        if (presenter.checkEmptyFields(email, password)) {
            toast("Complete both fields")
        } else {
            presenter.signInUserWithEmailAndPassword(email, password)
        }
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    override fun navigateToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.dettachView()
        presenter.dettachJob()
    }

    override fun onDestroy() {
        presenter.dettachView()
        presenter.dettachJob()
        super.onDestroy()
    }
}