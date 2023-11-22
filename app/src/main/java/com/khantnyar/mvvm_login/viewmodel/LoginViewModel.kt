package com.khantnyar.mvvm_login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.khantnyar.mvvm_login.repository.UserRepository
import com.khantnyar.mvvm_login.data.api.BaseResponse
import com.khantnyar.mvvm_login.data.api.request.LoginRequest
import com.khantnyar.mvvm_login.data.api.response.LoginResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(application:Application) : AndroidViewModel(application) {
    val userRepo = UserRepository()
    val loginResult: MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()

    fun loginUser(login:String,pwd:String){
        loginResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val loginRequest = LoginRequest(
                    params = LoginRequest.Params(
                        db = "odoo15",
                        login = login,
                        password = pwd
                    )
                )

                val response = userRepo.loginUser(loginRequest = loginRequest)
                if (response?.code() == 200) {
                    loginResult.value = BaseResponse.Success(response.body())
                } else {
                    loginResult.value = BaseResponse.Error(response?.message())
                }
            } catch (ex:Exception){
                loginResult.value = BaseResponse.Error(ex.message)
            }
        }
    }
}