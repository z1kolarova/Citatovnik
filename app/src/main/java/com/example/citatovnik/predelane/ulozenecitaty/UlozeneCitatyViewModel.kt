package com.example.citatovnik.predelane.ulozenecitaty

import androidx.lifecycle.*
import com.example.citatovnik.predelane.db.CitatDBItem
import com.example.citatovnik.predelane.db.CitatRepository
import kotlinx.coroutines.launch

class UlozeneCitatyViewModel ( private val repository: CitatRepository) : ViewModel() {
    val vsechnyUlozeneCitaty: LiveData<List<CitatDBItem>> = repository.vsechnyUlozeneCitaty.asLiveData()

    private val _citat = MutableLiveData<CitatDBItem?>()
    val citat: LiveData<CitatDBItem?>
        get() = _citat

    fun OnDeleteClicked(citatDBItem: CitatDBItem){
        viewModelScope.launch {repository.delete(citatDBItem)}
    }
}