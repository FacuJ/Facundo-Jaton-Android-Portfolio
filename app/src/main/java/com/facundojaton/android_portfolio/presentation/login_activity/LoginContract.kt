package com.facundojaton.android_portfolio.presentation.login_activity

interface LoginContract {

    interface View {
        fun activateWaitingMode()
        fun deactivateWaitingMode()
        fun showMessage(message: String?)
        fun login()
        fun navigateToMain()
        fun navigateToRegister()
    }

    interface Presenter {
        fun attachView(view: LoginContract.View)
        fun dettachView()
        fun dettachJob()
        fun isViewAttached(): Boolean
        fun signInUserWithEmailAndPassword(
            email: String,
            pass: String
        )
        fun checkEmptyFields(
            email: String,
            pass: String
        ): Boolean

    }
}