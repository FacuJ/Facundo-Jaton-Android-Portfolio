package com.facundojaton.servnetworkapp.domain.interactor.login_interactor

interface SignInInteractor {

    interface SignInCallback {
        fun onSignInSuccess()
        fun onSignInFailure(errorMessage: String)
    }

    fun signInWithEmailAndPassword(
        email:String,
        password: String,
        listener: SignInCallback
    )
}