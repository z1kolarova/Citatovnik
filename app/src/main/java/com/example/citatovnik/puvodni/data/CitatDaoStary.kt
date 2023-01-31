package com.example.citatovnik.puvodni.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CitatDaoStary {
    private val citatList = mutableListOf<Citat>()
    private val citaty = MutableLiveData<List<Citat>>()

    init{
        citaty.value = citatList
    }

    fun pridejCitat(citat: Citat) {
        citatList.add(citat)
        citaty.value = citatList
    }

    fun vratCitaty() = citaty as LiveData<List<Citat>>
}