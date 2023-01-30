package com.example.citatovnik.utilities

import com.example.citatovnik.data.CitatRepository
import com.example.citatovnik.data.FakeDatabaze
import com.example.citatovnik.ui.CitatyViewModelFactory

object InjectorUtils {
    fun dejCitatyViewModelFactory(): CitatyViewModelFactory {
        val citatRepository = CitatRepository.vratInstanci(FakeDatabaze.vratInsanci().citatDao)
        return CitatyViewModelFactory(citatRepository)
    }
}