package com.example.shimmereffect.utils

import android.app.Application
import com.example.shimmereffect.model.remote.ApiService
import com.example.shimmereffect.repository.MainRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object{
        lateinit var instance : App

        private val RetrofitInstance : Retrofit.Builder by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        }

        private val NetworkCall : ApiService by lazy {
            RetrofitInstance.build().create(ApiService::class.java)
        }

        val NetworkRepository : MainRepositoryImpl by lazy {
            MainRepositoryImpl(NetworkCall)
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}