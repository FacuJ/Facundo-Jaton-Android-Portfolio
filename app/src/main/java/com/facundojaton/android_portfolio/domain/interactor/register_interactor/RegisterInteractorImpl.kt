package com.facundojaton.android_portfolio.domain.interactor.register_interactor

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegisterInteractorImpl : RegisterInteractor {
    override fun signUp(
        fullName: String,
        email: String,
        password: String,
        listener: RegisterInteractor.RegisterCallback
    ) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(fullName)
                        .build()
                    FirebaseAuth.getInstance().currentUser?.updateProfile(profileUpdates)
                        ?.addOnCompleteListener {
                            if (it.isSuccessful) {
                                listener.onRegisterSuccess()
                            } else listener.onRegisterFailure(it.exception?.message.toString())
                        }
                } else {
                    listener.onRegisterFailure(
                        task.exception?.message.toString()
                    )
                }
            }
    }
}