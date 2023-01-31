package com.example.citatovnik.puvodni.data

data class Citat (val citatText: String,
                  val autor: String){
    override fun toString(): String {
        return "$citatText - $autor"
    }
}