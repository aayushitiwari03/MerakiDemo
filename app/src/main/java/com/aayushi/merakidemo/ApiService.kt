package com.aayushi.merakidemo


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("pathways")
    fun getPathways(
        @Query("appVersion") appVersion: Int = BuildConfig.VERSION_CODE,
        @Query("courseType") courseType: String = "json",
    ): Call<PathwayContainer>
}




object RetrofitInstance {
    val api:ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://merd-api.merakilearn.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}