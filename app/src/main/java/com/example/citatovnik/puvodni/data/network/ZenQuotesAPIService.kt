package com.example.citatovnik.puvodni.data.network

import com.example.citatovnik.puvodni.data.network.response.CitatDneResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://zenquotes.io?"
const val API_MODE = "today"

interface ZenQuotesAPIService {
    @GET("https://zenquotes.io?")
    fun vratCitatDne(
        @Query("api") mode: String = API_MODE
    ): Deferred<CitatDneResponse>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): ZenQuotesAPIService {
            val requestInterceptor = Interceptor {chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api", API_MODE)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(ZenQuotesAPIService::class.java)
        }
    }
}