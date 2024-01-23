package com.example.onschedule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var handler = Handler(Looper.myLooper()!!)
        handler.postDelayed({
            startActivity(Intent(this@SplashScreen,MainActivity::class.java))
        }, 4000)


    }
}