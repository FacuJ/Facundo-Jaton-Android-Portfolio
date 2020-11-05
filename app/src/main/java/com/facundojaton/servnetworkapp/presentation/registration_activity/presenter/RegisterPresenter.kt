package com.facundojaton.servnetworkapp.presentation.registration_activity.presenter

import androidx.core.util.PatternsCompat
import com.facundojaton.servnetworkapp.domain.interactor.register_interactor.RegisterInteractor
import com.facundojaton.servnetworkapp.presentation.registration_activity.RegisterContract

class RegisterPresenter(registerInteractor: RegisterInteractor) :
    RegisterContract.RegisterPresenter {

    var view: RegisterContract.RegisterView? = null
    var registerInteractor: RegisterInteractor? = null

    init {
        this.registerInteractor = registerInteractor
    }

    override fun attachView(view: RegisterContract.RegisterView) {
        this.view = view
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun detachView() {
        view = null
    }

    override fun checkEmptyEmailAndName(fullName: String, email: String): Boolean {
        return fullName.isEmpty() || email.isEmpty()
    }

    override fun checkValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun checkEmptyPasswords(passwordA: String, passwordB: String): Boolean {
        return passwordA.isEmpty() || passwordB.isEmpty()
    }

    override fun checkPasswordsMatch(passwordA: String, passwordB: String): Boolean {
        return passwordA == passwordB
    }

    override fun signUp(fullName: String, email: String, password: String) {
        TODO("Not yet implemented")
    }
}