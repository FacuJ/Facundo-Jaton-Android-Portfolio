package com.facundojaton.servnetworkapp.presentation.login_activity.presenter

import com.facundojaton.servnetworkapp.base.BasePresenter
import com.facundojaton.servnetworkapp.domain.interactor.LoginInteractor
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract

class LoginPresenter() : LoginContract.Presenter {
    var view: LoginContract.View? = null

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
        view?.showMessage("ERROR FROM PRESENTER")
    }

    override fun checkEmptyFields(email: String, pass: String): Boolean {
        return email.isEmpty() || pass.isEmpty()
    }

}