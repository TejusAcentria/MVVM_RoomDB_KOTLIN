package com.turtlemint.service

import com.turtlemint.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        private  var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        private var okhttpclient = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()
        private  var retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL).client(okhttpclient).build()
        var apiInterface: ApiInterface = retrofit.create(ApiInterface::class.java)
    }
}