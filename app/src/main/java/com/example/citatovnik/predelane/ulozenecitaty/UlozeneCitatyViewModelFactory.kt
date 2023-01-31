package com.example.citatovnik.predelane.ulozenecitaty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.citatovnik.predelane.db.CitatRepository

class UlozeneCitatyViewModelFactory ( private val repository: CitatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(UlozeneCitatyViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return UlozeneCitatyViewModel(repository) as T
        }
        throw IllegalArgumentException("Neznámá ViewModel třída")
    }
}