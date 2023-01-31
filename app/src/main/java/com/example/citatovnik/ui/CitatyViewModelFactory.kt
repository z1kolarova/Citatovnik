package com.example.citatovnik.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.citatovnik.data.repositories.CitatRepositoryImpl

class CitatyViewModelFactory(private val citatRepositoryImpl: CitatRepositoryImpl)
    : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override  fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CitatyViewModel(citatRepositoryImpl) as T
    }
}