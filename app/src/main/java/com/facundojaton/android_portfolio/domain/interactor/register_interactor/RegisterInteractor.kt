package com.facundojaton.android_portfolio.domain.interactor.register_interactor

interface RegisterInteractor {

    interface RegisterCallback {
        fun onRegisterSuccess()
        fun onRegisterFailure(errorMessage: String)
    }

    fun signUp(fullName: String, email: String, password:String, listener:RegisterCallback )
}