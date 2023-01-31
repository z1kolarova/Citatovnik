package com.example.citatovnik.data.network

import androidx.lifecycle.LiveData
import com.example.citatovnik.data.db.entity.CitatDneResponseItem

interface CitatyDataSource {
    val downloadedCitatDne: LiveData<CitatDneResponseItem>

    suspend fun dotahniCitatDne(

    )
}