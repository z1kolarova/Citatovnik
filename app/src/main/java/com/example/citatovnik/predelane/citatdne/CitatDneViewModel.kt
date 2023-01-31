package com.example.citatovnik.predelane.citatdne

import android.location.Location
import androidx.lifecycle.*
import com.example.citatovnik.predelane.db.CitatDBItem
import com.example.citatovnik.predelane.db.CitatRepository
import com.example.citatovnik.puvodni.data.Citat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class CitatDneViewModel( private val repository: CitatRepository) : ViewModel() {

    private val _citat = MutableLiveData<Flow<CitatDBItem>>()
    val citatDne: LiveData<Flow<CitatDBItem>>
        get() = _citat

    init {
        _citat.value = repository.citatDne
    }
}