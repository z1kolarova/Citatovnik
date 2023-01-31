package com.example.citatovnik.predelane

import android.app.Application
import com.example.citatovnik.predelane.db.CitatRepository
import com.example.citatovnik.predelane.db.CitatyRoomDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CitatovnikApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { CitatyRoomDB.getDatabase(this, applicationScope) }
    val repository by lazy { CitatRepository(database.citatyDao()) }
}