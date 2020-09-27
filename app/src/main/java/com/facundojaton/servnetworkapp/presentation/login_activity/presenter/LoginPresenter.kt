package com.facundojaton.servnetworkapp.presentation.login_activity.presenter

import com.facundojaton.servnetworkapp.base.BasePresenter
import com.facundojaton.servnetworkapp.domain.interactor.LoginInteractor
import com.facundojaton.servnetworkapp.domain.interactor.login_interactor.SignInInteractor
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract

class LoginPresenter(signInInteractor: SignInInteractor) : LoginContract.Presenter {

    var view: LoginContract.View? = null
    var signInInteractor: SignInInteractor? = null

    init {
        this.signInInteractor = signInInteractor
    }

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun signInUserWithEmailAndPassword(email: String, pass: String) {
        view?.activateWaitingMode()
        //ToDo: Interactor Logic with callbacks
        signInInteractor?.signInWithEmailAndPassword(
            email, pass, object : SignInInteractor.SignInCallback{
                override fun onSignInSuccess() {
                    if(isViewAttached()){
                        view?.deactivateWaitingMode()
                        view?.navigateToMain()
                    }
                }

                override fun onSignInFailure(errorMessage: String) {
                    if(isViewAttached()){
                        view?.deactivateWaitingMode()
                        view?.showMessage(errorMessage)
                    }
                }

            }
        )
        view?.showMessage("ERROR FROM PRESENTER")
    }

    override fun checkEmptyFields(email: String, pass: String): Boolean {
        return email.isEmpty() || pass.isEmpty()
    }

}