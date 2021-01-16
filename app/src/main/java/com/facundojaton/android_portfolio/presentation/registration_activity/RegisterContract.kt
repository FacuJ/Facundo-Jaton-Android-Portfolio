package com.facundojaton.android_portfolio.presentation.registration_activity

interface RegisterContract {

    interface RegisterView {
        fun navigateToMain()
        fun signUp()
        fun showProgress()
        fun hideProgress()
        fun showError(errorMessage: String)
    }

    interface RegisterPresenter {
        fun attachView(view: RegisterView)
        fun isViewAttached(): Boolean
        fun detachView()
        fun checkEmptyEmailAndName(fullName: String, email: String): Boolean
        fun checkValidEmail(email: String): Boolean
        fun checkEmptyPasswords(passwordA: String, passwordB: String): Boolean
        fun checkPasswordsMatch(passwordA: String, passwordB: String): Boolean
        fun signUp(fullName: String, email: String, password: String)
    }
}