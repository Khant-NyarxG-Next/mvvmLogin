package com.khantnyar.mvvm_login.ui

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.khantnyar.mvvm_login.data.api.BaseResponse
import com.khantnyar.mvvm_login.data.api.response.LoginResponse
import com.khantnyar.mvvm_login.databinding.ActivityLoginBinding
import com.khantnyar.mvvm_login.utils.SessionManager
import com.khantnyar.mvvm_login.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val token = SessionManager.getToken(this)
        if(!token.isNullOrBlank()){
            navigateToHome()
        }

        viewModel.loginResult.observe(this){
            when(it){
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(it.data)
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }
                else -> {
                    stopLoading()
                }
            }
        }

        binding.btnLogin.setOnClickListener {
            doLogin()
        }

        binding.btnRegister.setOnClickListener {
            doSignup()
        }
    }

    private fun navigateToHome(){
        val intent:Intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }
    fun doLogin() {
        val login = binding.txtInputEmail.text.toString()
        val pwd = binding.txtPass.text.toString()
        viewModel.loginUser(login = login, pwd = pwd)
    }

    fun doSignup() {

    }

    fun showLoading() {
        binding.prgbar.visibility = View.VISIBLE
    }

    fun stopLoading() {
        binding.prgbar.visibility = View.GONE
    }

    fun processLogin(data: LoginResponse?) {
        showToast("Success:" + data?.result?.name)
        if (!data?.result?.name.isNullOrEmpty()) {
            data?.result?.name?.let { SessionManager.saveAuthToken(this, it) }
            navigateToHome()
        }
    }

    fun processError(msg: String?) {
        showToast("Error:" + msg)
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

//    https://harshitabambure.medium.com/login-api-with-retrofit-and-mvvm-with-auto-login-in-android-kotlin-bb6907092e0c
//    https://github.com/HarshitaBambure/RetrofitLogin/blob/master/app/src/main/java/com/harshita/retrofitlogin/repository/UserRepository.kt

}