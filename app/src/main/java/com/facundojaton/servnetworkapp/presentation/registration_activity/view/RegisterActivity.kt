package com.facundojaton.servnetworkapp.presentation.registration_activity.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facundojaton.servnetworkapp.R
import com.facundojaton.servnetworkapp.base.BaseActivity
import com.facundojaton.servnetworkapp.presentation.main_activity.view.MainActivity
import com.facundojaton.servnetworkapp.presentation.registration_activity.RegisterContract

class RegisterActivity : BaseActivity(), RegisterContract.RegisterView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayout(): Int {
        return R.layout.activity_register
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun signUp() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }

    override fun showError(errorMessage: String) {
        toast(errorMessage)
    }
}