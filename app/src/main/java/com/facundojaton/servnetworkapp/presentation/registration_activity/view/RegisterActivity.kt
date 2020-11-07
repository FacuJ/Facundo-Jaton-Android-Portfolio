package com.facundojaton.servnetworkapp.presentation.registration_activity.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.facundojaton.servnetworkapp.R
import com.facundojaton.servnetworkapp.base.BaseActivity
import com.facundojaton.servnetworkapp.domain.interactor.register_interactor.RegisterInteractorImpl
import com.facundojaton.servnetworkapp.presentation.main_activity.view.MainActivity
import com.facundojaton.servnetworkapp.presentation.registration_activity.RegisterContract
import com.facundojaton.servnetworkapp.presentation.registration_activity.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterContract.RegisterView {

    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = RegisterPresenter(RegisterInteractorImpl())
        presenter.attachView(this)

        btn_register?.setOnClickListener {
            signUp()
        }
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
        val fullName: String = et_register_name.text.toString().trim()
        val email: String = et_register_email.text.toString().trim()
        val password = et_register_password.text.toString().trim()
        val passwordRepeat = et_repeat_register_password.text.toString().trim()

        /** -- ToDo All the logic should be on presenter, for testeability sake,
         * that also includes the following if statements (!) **/

        if (presenter.checkEmptyEmailAndName(fullName, email)) {
            //toDo: fix this -> separate both fields maybe
            et_register_name.error = "Name or email invalid"
            return
        }
        if (!presenter.checkValidEmail(email)) {
            et_register_email.error = "Email invalid"
            return
        }
        if (presenter.checkEmptyPasswords(password, passwordRepeat)) {
            et_register_password.error = "Empty field"
            et_repeat_register_password.error = "Empty field"
            return
        }
        if (!presenter.checkPasswordsMatch(password, passwordRepeat)) {
            et_register_password.error = "Passwords don't match"
            et_repeat_register_password.error = "Passwords don't match"
            return
        }
        presenter.signUp(fullName, email, password)
    }

    override fun showProgress() {
        pb_register.visibility = View.VISIBLE
        btn_register.isEnabled = false
    }

    override fun hideProgress() {
        pb_register?.visibility = View.GONE
        btn_register.isEnabled = true
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