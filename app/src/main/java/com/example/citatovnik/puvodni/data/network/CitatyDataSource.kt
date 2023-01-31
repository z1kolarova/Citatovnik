package com.example.citatovnik.puvodni.data.network

import androidx.lifecycle.LiveData
import com.example.citatovnik.puvodni.data.db.entity.CitatDneResponseItem

interface CitatyDataSource {
    val downloadedCitatDne: LiveData<CitatDneResponseItem>

    suspend fun dotahniCitatDne(

    )
}