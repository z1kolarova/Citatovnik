package com.example.citatovnik.predelane.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "citaty")
class CitatDBItem (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("q")
    val zneniCitatu: String,
    @SerializedName("a")
    val autor: String
)