package com.example.citatovnik.predelane.ulozenecitaty

import android.location.Location
import androidx.lifecycle.*
import com.example.citatovnik.predelane.db.CitatDBItem
import com.example.citatovnik.predelane.db.CitatRepository
import kotlinx.coroutines.launch

class UlozeneCitatyViewModel ( private val repository: CitatRepository) : ViewModel() {

    val vsechnyUlozeneCitaty: LiveData<List<CitatDBItem>> = repository.vsechnyUlozeneCitaty.asLiveData()

   private val _vsechnyCitaty = MutableLiveData<List<CitatDBItem>>()
    val citat: LiveData<List<CitatDBItem>>
        get() = _vsechnyCitaty

    fun OnDeleteClicked(citatDBItem: CitatDBItem){
        viewModelScope.launch {repository.delete(citatDBItem)}
    }
}