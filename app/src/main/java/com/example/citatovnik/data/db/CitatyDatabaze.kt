package com.example.citatovnik.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.citatovnik.data.db.entity.CitatDneResponseItem

@Database(
    entities = [CitatDneResponseItem::class],
    version = 1
)
abstract class CitatyDatabaze : RoomDatabase() {
    abstract  fun citatDneDao(): CitatDneDao

    companion object{
        @Volatile private var instance: CitatyDatabaze? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                CitatyDatabaze::class.java, "citatovnik.db")
                .build()
    }
}
