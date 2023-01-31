package com.example.citatovnik.predelane.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CITAT_DNE_ID = 0

@Entity("citatDne")
class CitatDneDBItem (
    @SerializedName("q")
    val zneniCitatu: String,
    @SerializedName("a")
    val autor: String
)
{
    @PrimaryKey(autoGenerate = false)
    var id: Int = CITAT_DNE_ID
}