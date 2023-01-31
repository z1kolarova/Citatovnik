package com.example.citatovnik.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.citatovnik.data.Citat
import com.example.citatovnik.data.CitatDao
import com.example.citatovnik.data.db.CitatDneDao
import com.example.citatovnik.data.db.entity.CitatDneResponseItem
import com.example.citatovnik.data.network.CitatyDataSource
import com.example.citatovnik.data.network.response.CitatDneResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime

class CitatRepositoryImpl internal constructor(
    private val citatDneDao: CitatDneDao,
    private val citatyDataSource: CitatyDataSource
): CitatRepository  {

    init {
        citatyDataSource.downloadedCitatDne.observeForever{ novyCitatDne ->

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun vratCitatDne(): LiveData<CitatDneResponseItem> {
        return withContext(Dispatchers.IO) {
            initCitatDne()
            return@withContext citatDneDao.vratCitatDne()
        }
    }

    private fun persistDotazenyCitatDne(dotazenyCitatDne: CitatDneResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            citatDneDao.upsert(dotazenyCitatDne.first())
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun initCitatDne() {
        if(potrebujuNovejsi(ZonedDateTime.now(ZoneId.of("America/Chicago"))))
            dotahniCitatDne()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun potrebujuNovejsi(lastFetchTime: ZonedDateTime): Boolean {
        val nyniCST = ZonedDateTime.now(ZoneId.of("America/Chicago"))
        val minulaPulnocCST = nyniCST.toLocalDate().atStartOfDay(nyniCST.zone)
        return lastFetchTime.isBefore(minulaPulnocCST)
    }

    private suspend fun dotahniCitatDne()
    {
        citatyDataSource.dotahniCitatDne()
    }

/*
    fun pridejCitat(citat: Citat) {
        citatDao.pridejCitat(citat)
    }

    fun vratCitaty() = citatDao.vratCitaty()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: CitatRepositoryImpl? = null

        fun vratInstanci(citatDao: CitatDao) =
            instance ?: synchronized(this) {
                instance ?: CitatRepositoryImpl(citatDao).also { instance = it }
            }
    }

 */
}