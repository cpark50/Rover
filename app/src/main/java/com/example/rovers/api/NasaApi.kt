package com.example.rovers.api

import com.example.rovers.Photos
import retrofit2.Call
import retrofit2.http.GET

interface NasaApi {
    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=AyHYvkgDh4gCmDpuFPUj5kmc2nLHsJS5ikGGHKHe")
    fun getNasaInfo() : Call<Photos>

}