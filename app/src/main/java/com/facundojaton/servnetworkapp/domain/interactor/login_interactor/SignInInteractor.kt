package com.facundojaton.servnetworkapp.domain.interactor.login_interactor

interface SignInInteractor {
    suspend fun signInWithEmailAndPassword(
        email: String, password: String
    )
}