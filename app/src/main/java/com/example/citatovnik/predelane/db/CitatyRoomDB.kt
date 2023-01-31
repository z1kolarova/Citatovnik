package com.example.citatovnik.predelane.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [CitatDBItem::class, CitatDneDBItem::class], version = 1, exportSchema = false)
public abstract class CitatyRoomDB: RoomDatabase() {
    abstract fun citatyDao(): CitatyDao

    private class CitatyRoomDBCallback(private val scope: CoroutineScope) :
        RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var citatyDao = database.citatyDao()
                    //Všechno smazat
                    citatyDao.upsert(CitatDBItem(1, "Ach jo", "já"))
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: CitatyRoomDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): CitatyRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CitatyRoomDB::class.java,
                    "citaty"
                ).addCallback(
                    CitatyRoomDBCallback(scope)
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}