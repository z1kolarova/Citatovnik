package com.example.citatovnik.predelane.db

import androidx.room.*
import com.example.citatovnik.puvodni.data.Citat
import kotlinx.coroutines.flow.Flow

@Dao
interface CitatyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(citaty: CitatDBItem)

    @Query("select * from citaty where id = $CITAT_DNE_ID")
    fun vratCitatDne(): Flow<CitatDBItem>

    @Query("select * from citaty where id > $CITAT_DNE_ID")
    fun vratUlozeneCitaty(): Flow<List<CitatDBItem>>

    @Delete
    suspend fun vymaz(citaty: CitatDBItem)
}