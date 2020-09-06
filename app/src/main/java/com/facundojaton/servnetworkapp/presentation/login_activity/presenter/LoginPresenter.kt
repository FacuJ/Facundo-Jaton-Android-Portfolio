package com.facundojaton.servnetworkapp.presentation.login_activity.presenter

import com.facundojaton.servnetworkapp.base.BasePresenter
import com.facundojaton.servnetworkapp.domain.interactor.LoginInteractor
import com.facundojaton.servnetworkapp.presentation.login_activity.LoginContract

class LoginPresenter constructor(
    view: LoginContract.View,
    loginInteractor: LoginInteractor
) : BasePresenter(),
    LoginContract.Presenter {

    var view: LoginContract.View? = null
    var loginInteractor: LoginInteractor? = null

    init {
        this.view = view
        this.loginInteractor = loginInteractor
    }


}