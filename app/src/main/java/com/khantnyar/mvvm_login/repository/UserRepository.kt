package com.khantnyar.mvvm_login.repository

import com.khantnyar.mvvm_login.data.api.request.LoginRequest
import com.khantnyar.mvvm_login.data.api.response.LoginResponse
import com.khantnyar.mvvm_login.data.api.methods.Auth
import retrofit2.Response

class UserRepository {
    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  Auth.getApi()?.loginUser(loginRequest = loginRequest)
    }
}