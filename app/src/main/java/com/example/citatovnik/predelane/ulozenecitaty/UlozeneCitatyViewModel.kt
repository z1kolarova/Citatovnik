package com.example.citatovnik.predelane.ulozenecitaty

import android.location.Location
import androidx.lifecycle.*
import com.example.citatovnik.predelane.db.CitatDBItem
import com.example.citatovnik.predelane.db.CitatRepository
import com.example.citatovnik.puvodni.data.Citat
import kotlinx.coroutines.launch

class UlozeneCitatyViewModel ( private val repository: CitatRepository) : ViewModel() {
    val wholeHistory: LiveData<List<CitatDBItem>> = repository.vsechnyUlozeneCitaty.asLiveData()

    private val _citat = MutableLiveData<CitatDBItem?>()
    val location: LiveData<CitatDBItem?>
        get() = _citat

    fun ResetLocation(){
        _citat.value = null
    }

    fun OnDeleteClicked(citatDBItem: CitatDBItem){
        viewModelScope.launch {repository.delete(citatDBItem)}
    }
}