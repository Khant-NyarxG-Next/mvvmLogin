package com.khantnyar.mvvm_login.data.api.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("jsonrpc") var jsonrpc: String = "2.0",
    @SerializedName("params") var params: Params?
){
    data class Params (
        @SerializedName("db") var db: String = "odoo16",
        @SerializedName("login") var login: String?,
        @SerializedName("password") var password: String?
    )
}
