package com.facundojaton.android_portfolio.presentation.registration_activity.presenter

import androidx.core.util.PatternsCompat
import com.facundojaton.android_portfolio.domain.interactor.register_interactor.RegisterInteractor
import com.facundojaton.android_portfolio.presentation.registration_activity.RegisterContract

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
        view?.showProgress()
        registerInteractor?.signUp(
            fullName,
            email,
            password,
            object : RegisterInteractor.RegisterCallback {
                override fun onRegisterSuccess() {
                    view?.navigateToMain()
                    view?.hideProgress()
                }

                override fun onRegisterFailure(errorMessage: String) {
                    view?.showError(errorMessage)
                    view?.hideProgress()
                }

            })
    }
}