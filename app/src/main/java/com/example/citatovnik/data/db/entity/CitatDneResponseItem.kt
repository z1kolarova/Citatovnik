package com.example.citatovnik.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CITAT_DNE_ID = 0

@Entity(tableName = "citat_dne")
data class CitatDneResponseItem(
    @SerializedName("q")
    val zneniCitatu: String,
    @SerializedName("a")
    val autor: String,
    @SerializedName("h")
    val htmlForma: String
)
{
    @PrimaryKey(autoGenerate = false)
    var id: Int = CITAT_DNE_ID
}