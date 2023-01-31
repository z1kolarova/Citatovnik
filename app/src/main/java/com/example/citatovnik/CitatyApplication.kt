package com.example.citatovnik

import android.app.Application
import androidx.room.RoomDatabase
import com.example.citatovnik.data.Citat
import com.example.citatovnik.data.db.CitatDneDao
import com.example.citatovnik.data.db.CitatyDatabaze
import com.example.citatovnik.data.network.*
import com.example.citatovnik.data.repositories.CitatRepository
import com.example.citatovnik.data.repositories.CitatRepositoryImpl
import com.example.citatovnik.ui.citaty.citat_dne.CitatDneViewModelFactory
import com.github.salomonbrys.kodein.*


class CitatyApplication : Application(), KodeinAware {
    @Volatile
    var created = false;
    override val kodein = Kodein {
        bind() from singleton { CitatyDatabaze(instance()) }
        bind() from singleton { instance<CitatyDatabaze>().citatDneDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ZenQuotesAPIService(instance()) }
        bind<CitatyDataSource>() with singleton { CitatyDataSourceImpl(instance()) }
        bind<CitatRepository>() with singleton { CitatRepositoryImpl(instance(), instance()) }
        bind() from provider { CitatDneViewModelFactory(instance())}
    }

    override fun onCreate() {
        super.onCreate()
    }
}

