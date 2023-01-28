package com.example.citatovnik.data

class CitatRepository private constructor(private val citatDao: CitatDao) {

    fun pridejCitat(citat: Citat) {
        citatDao.pridejCitat(citat)
    }

    fun vratCitaty() = citatDao.vratCitaty()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: CitatRepository? = null

        fun vratInstanci(citatDao: CitatDao) =
            instance ?: synchronized(this) {
                instance ?: CitatRepository(citatDao).also { instance = it }
            }
    }
}