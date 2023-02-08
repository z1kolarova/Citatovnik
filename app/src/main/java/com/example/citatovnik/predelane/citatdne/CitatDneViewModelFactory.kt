package com.example.citatovnik.predelane.citatdne

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.citatovnik.predelane.CitatovnikApplication
import com.example.citatovnik.predelane.db.CitatRepository
import com.example.citatovnik.puvodni.data.network.ZenQuotesAPIService

class CitatDneViewModelFactory( private val repository: CitatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(CitatDneViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CitatDneViewModel(repository) as T
        }
        throw IllegalArgumentException("Neznámá ViewModel třída")
    }
}