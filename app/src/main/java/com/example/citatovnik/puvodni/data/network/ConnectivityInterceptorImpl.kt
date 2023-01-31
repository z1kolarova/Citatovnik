package com.example.citatovnik.puvodni.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.citatovnik.puvodni.internal.NeniPripojeniException
import okhttp3.Interceptor
import okhttp3.Response


class ConnectivityInterceptorImpl(
    context: Context
) : ConnectivityInterceptor {

    private val appContext = context.applicationContext

    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!jeOnline())
            throw NeniPripojeniException()
        return chain.proceed(chain.request())
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun jeOnline() : Boolean{
        val connectvityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectvityManager.getNetworkCapabilities((connectvityManager.activeNetwork))
        return networkCapabilities != null
                && (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
    }
}