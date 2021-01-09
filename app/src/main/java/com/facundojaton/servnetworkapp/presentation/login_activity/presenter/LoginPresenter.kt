package com.facundojaton.servnetworkapp.presentation.login_activity.presenter

import com.facundojaton.servnetworkapp.domain.interactor.login_interactor.SignInInteractor
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LoginPresenter(signInInteractor: SignInInteractor) : LoginContract.Presenter,
    CoroutineScope {

    var view: LoginContract.View? = null
    var signInInteractor: SignInInteractor? = null
    val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    init {
        this.signInInteractor = signInInteractor
    }

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun dettachJob() {
        coroutineContext.cancel()
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun signInUserWithEmailAndPassword(email: String, pass: String) {
        launch {
            view?.activateWaitingMode()
            try {
                signInInteractor?.signInWithEmailAndPassword(email, pass)
                if (isViewAttached()) {
                    view?.deactivateWaitingMode()
                    view?.navigateToMain()
                }
            } catch (e: Exception) {
                if (isViewAttached()) {
                    view?.showMessage(e.message)
                    view?.deactivateWaitingMode()
                }
            }
        }
    }

    override fun checkEmptyFields(email: String, pass: String): Boolean {
        return email.isEmpty() || pass.isEmpty()
    }

}