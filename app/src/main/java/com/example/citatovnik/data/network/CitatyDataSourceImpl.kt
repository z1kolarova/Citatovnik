package com.example.citatovnik.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.citatovnik.data.db.entity.CitatDneResponseItem
import com.example.citatovnik.data.network.response.CitatDneResponse
import com.example.citatovnik.internal.NeniPripojeniException

class CitatyDataSourceImpl(
    private val zenQuotesAPIService: ZenQuotesAPIService
) : CitatyDataSource {

    private val _dotazenyCitatDne = MutableLiveData<CitatDneResponseItem>()

    override val downloadedCitatDne: LiveData<CitatDneResponseItem>
        get() = _dotazenyCitatDne

    override suspend fun dotahniCitatDne() {
        try {
            val dotazenyCitatDne = zenQuotesAPIService
                .vratCitat()
                .await()
            _dotazenyCitatDne.postValue(dotazenyCitatDne.first())
        }
        catch (e: NeniPripojeniException) {
            Log.e("Připojení", "Není dostupné připojení k internetu.", e)
        }
    }
}