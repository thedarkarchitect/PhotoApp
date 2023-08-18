package com.example.marsphotos.network
import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.GET


//URL
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
//add retrofit builder
private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService{//defines how retrofit talks to the web server using HTTP requests
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto> //makes the function asynchronous and not block the calling thread
}

object MarsApi{//this initializes the retrofit service
    val retrofitService : MarsApiService by lazy{
//        The caller accesses the same singleton retrofit object that implements MarsApiService thru this object
        retrofit.create(MarsApiService::class.java)
    }
}