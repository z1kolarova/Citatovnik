package com.example.citatovnik.ui.citaty

import androidx.lifecycle.ViewModel
import com.example.citatovnik.data.Citat
import com.example.citatovnik.data.CitatRepository

class CitatyViewModel(private val citatRepository: CitatRepository) :ViewModel() {

    fun vratCitaty() = citatRepository.vratCitaty()

    fun pridejCitat(citat: Citat) = citatRepository.pridejCitat(citat)
}