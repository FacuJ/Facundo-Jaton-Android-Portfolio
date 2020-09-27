package com.facundojaton.servnetworkapp.domain.interactor.login_interactor

import com.google.firebase.auth.FirebaseAuth

class SignInInteractorImpl : SignInInteractor {

    override fun signInWithEmailAndPassword(
        email: String,
        password: String,
        listener: SignInInteractor.SignInCallback
    ) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(
            email, password
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                listener.onSignInSuccess()
            } else {
                task.exception?.message?.let {
                    listener.onSignInFailure(it)
                }
            }
        }
    }

}