package com.khantnyar.mvvm_login.data.api.methods

import com.khantnyar.mvvm_login.data.api.request.LoginRequest
import com.khantnyar.mvvm_login.data.api.response.LoginResponse
import com.khantnyar.mvvm_login.utils.OdooApiClient
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Auth {
    @Headers("Content-Type: application/json")
    @POST("web/session/authenticate")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): Auth?{
            return OdooApiClient.client?.create(Auth::class.java)
        }
    }
}