package com.example.citatovnik.puvodni.data.db.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CITAT_DNE_ID = 0

@Entity(tableName = "citaty")
data class CitatDneResponseItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("q")
    val zneniCitatu: String,
    @SerializedName("a")
    val autor: String
)