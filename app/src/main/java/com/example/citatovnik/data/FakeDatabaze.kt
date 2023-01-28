package com.example.citatovnik.data

class FakeDatabaze private constructor(){

    var citatDao = CitatDao()
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