package com.facundojaton.android_portfolio.presentation.registration_activity.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.facundojaton.android_portfolio.base.BaseActivity
import com.facundojaton.android_portfolio.databinding.ActivityRegisterBinding
import com.facundojaton.android_portfolio.domain.interactor.register_interactor.RegisterInteractorImpl
import com.facundojaton.android_portfolio.presentation.main_activity.view.MainActivity
import com.facundojaton.android_portfolio.presentation.registration_activity.RegisterContract
import com.facundojaton.android_portfolio.presentation.registration_activity.presenter.RegisterPresenter

class RegisterActivity : BaseActivity(), RegisterContract.RegisterView {

    private lateinit var presenter: RegisterPresenter
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)

        presenter = RegisterPresenter(RegisterInteractorImpl())
        presenter.attachView(this)

        binding.apply {
            setContentView(root)
            btnRegister.setOnClickListener {
                signUp()
            }
        }
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun signUp() {
        val fullName: String = binding.etRegisterName.text.toString().trim()
        val email: String = binding.etRegisterEmail.text.toString().trim()
        val password = binding.etRegisterPassword.text.toString().trim()
        val passwordRepeat = binding.etRepeatRegisterPassword.text.toString().trim()

        /** -- All the logic should be on presenter, for testeability sake,
         * that also includes the following if statements (!) **/

        if (presenter.checkEmptyEmailAndName(fullName, email)) {
            binding.etRegisterName.error = "Name or email invalid"
            return
        }
        if (!presenter.checkValidEmail(email)) {
            binding.etRegisterEmail.error = "Email invalid"
            return
        }
        if (presenter.checkEmptyPasswords(password, passwordRepeat)) {
            binding.etRegisterPassword.error = "Empty field"
            binding.etRepeatRegisterPassword.error = "Empty field"
            return
        }
        if (!presenter.checkPasswordsMatch(password, passwordRepeat)) {
            binding.etRegisterPassword.error = "Passwords don't match"
            binding.etRepeatRegisterPassword.error = "Passwords don't match"
            return
        }
        presenter.signUp(fullName, email, password)
    }

    override fun showProgress() {
        binding.pbRegister.visibility = View.VISIBLE
        binding.btnRegister.isEnabled = false
    }

    override fun hideProgress() {
        binding.pbRegister.visibility = View.GONE
        binding.btnRegister.isEnabled = true
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