package com.example.citatovnik.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.citatovnik.data.Citat
import com.example.citatovnik.data.db.entity.CITAT_DNE_ID
import com.example.citatovnik.data.db.entity.CitatDneResponseItem

@Dao
interface CitatDneDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(citat: CitatDneResponseItem)

    @Query("select * from citat_dne where id = $CITAT_DNE_ID")
    fun vratCitatDne(): LiveData<CitatDneResponseItem>
}