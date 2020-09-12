package com.facundojaton.servnetworkapp.presentation.login_activity

interface LoginContract {

    interface View {
        fun activateWaitingMode()
        fun deactivateWaitingMode()
        fun showMessage(message: String)
        fun login()
    }

    interface Presenter {

    }
}