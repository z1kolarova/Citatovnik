package com.example.citatovnik.puvodni.data.repositories

import androidx.lifecycle.LiveData
import com.example.citatovnik.puvodni.data.db.entity.CitatDneResponseItem

interface CitatRepository {
    suspend fun vratCitatDne(): LiveData<CitatDneResponseItem>
}