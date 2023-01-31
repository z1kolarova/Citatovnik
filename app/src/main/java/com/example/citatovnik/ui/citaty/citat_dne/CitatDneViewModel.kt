package com.example.citatovnik.ui.citaty.citat_dne

import androidx.lifecycle.ViewModel
import com.example.citatovnik.data.repositories.CitatRepository
import com.example.citatovnik.internal.lazyDeferred

class CitatDneViewModel(
    private val citatRepository : CitatRepository
) : ViewModel() {
    val citat by lazyDeferred {
        citatRepository.vratCitatDne()
    }
}