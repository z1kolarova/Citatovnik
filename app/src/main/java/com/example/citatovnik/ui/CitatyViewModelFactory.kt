package com.example.citatovnik.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.citatovnik.data.CitatRepository

class CitatyViewModelFactory(private val citatRepository: CitatRepository)
    : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override  fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CitatyViewModel(citatRepository) as T
    }
}