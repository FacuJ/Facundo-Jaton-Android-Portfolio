package com.facundojaton.servnetworkapp.domain.interactor.login_interactor

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SignInInteractorImpl : SignInInteractor {

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Unit = suspendCancellableCoroutine { continuation ->
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    continuation.resume(Unit)
                } else {
                    continuation.resumeWithException(
                        Exception(task.exception?.message)
                    )
                }
            }
    }
}