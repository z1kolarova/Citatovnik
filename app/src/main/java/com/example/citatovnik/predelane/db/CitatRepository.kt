package com.example.citatovnik.predelane.db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class CitatRepository(private val citatyDao: CitatyDao) {
    val vsechnyUlozeneCitaty: Flow<List<CitatDBItem>> = citatyDao.vratUlozeneCitaty()
/*
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun vratVsechny(): Flow<List<CitatDBItem>> {
        return citatyDao.vratUlozeneCitaty()
    }*/

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun vratCitatDne(): CitatDneDBItem {
        return citatyDao.vratCitatDne()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(citat: CitatDBItem){
        citatyDao.upsert(citat)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(citat: CitatDneDBItem){
        citatyDao.upsert(citat)
    }

    suspend fun delete(citat: CitatDBItem){
        citatyDao.vymaz(citat)
    }
}