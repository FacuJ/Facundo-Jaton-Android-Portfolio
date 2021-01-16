package com.facundojaton.android_portfolio.domain.interactor.login_interactor

interface SignInInteractor {
    suspend fun signInWithEmailAndPassword(
        email: String, password: String
    )
}