package com.jesse.financeapp.activities.introActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jesse.financeapp.MainActivity
import com.jesse.financeapp.activities.introActivity.screens.IntroScreen

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroScreen(onStartClick = {
                startActivity(Intent(this, MainActivity::class.java))
            })
        }
    }
}