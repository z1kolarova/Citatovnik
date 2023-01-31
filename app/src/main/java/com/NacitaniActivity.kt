package com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.citatovnik.MainActivity
import com.example.citatovnik.R

class NacitaniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nacitani)

        supportActionBar?.hide()

        val intent = Intent(this, MainActivity::class.java)


        val secondThread = object: Thread(){
            override fun run() {
                try {
                    sleep(3000)
                    startActivity(intent)
                } catch (e: InterruptedException){
                    Log.e("welcome", "chyba: ${e.message}")
                } finally {
                    finish()
                }
            }
        }
        secondThread.start()
    }
}