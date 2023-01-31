package com.example.citatovnik.data.repositories

import androidx.lifecycle.LiveData
import com.example.citatovnik.data.db.entity.CitatDneResponseItem

interface CitatRepository {
    suspend fun vratCitatDne(): LiveData<CitatDneResponseItem>
}