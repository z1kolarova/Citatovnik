package com.example.citatovnik

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.citatovnik.puvodni.data.network.ZenQuotesAPIService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_citaty)



    }
}