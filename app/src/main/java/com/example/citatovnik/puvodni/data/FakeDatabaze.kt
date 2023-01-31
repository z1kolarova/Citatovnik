package com.example.citatovnik.puvodni.data

class FakeDatabaze private constructor(){

    var citatDaoStary = CitatDaoStary()
        private set

    companion object {
        @Volatile private var instance: FakeDatabaze? = null

        fun vratInsanci() =
            instance ?: synchronized (this)
            {
                instance ?: FakeDatabaze().also { instance = it }
            }
    }
}