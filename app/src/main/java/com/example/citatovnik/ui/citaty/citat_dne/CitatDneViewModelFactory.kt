package com.example.citatovnik.ui.citaty.citat_dne

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.citatovnik.data.repositories.CitatRepository

class CitatDneViewModelFactory(
    private val citatRepository: CitatRepository
) :ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CitatDneViewModel(citatRepository) as T
    }
}