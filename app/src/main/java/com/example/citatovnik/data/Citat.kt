package com.example.citatovnik.data

data class Citat (val citatText: String,
                  val autor: String){
    override fun toString(): String {
        return "$citatText - $autor"
    }
}