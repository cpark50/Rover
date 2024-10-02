package com.example.rovers.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.rovers.BuildConfig
import com.example.rovers.Photos
import com.example.rovers.api.NasaApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MarsRepository {
    private val nasaApi: NasaApi
    val marsInfoLiveData = MutableLiveData<List<Photos.MarsPhoto>>()
//
    init {
        val client = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor())
            .build()

        nasaApi = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NasaApi::class.java)
    }

    fun getNasaInfo() {
        nasaApi.getNasaInfo().enqueue(object: Callback<Photos> {
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                response.body()?.let { res ->
                    marsInfoLiveData.value = res.photos
                }
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                Log.d("", "onFailure")
            }

        })
    }
}