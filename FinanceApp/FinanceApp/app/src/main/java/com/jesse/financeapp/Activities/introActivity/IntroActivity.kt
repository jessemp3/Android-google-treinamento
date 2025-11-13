package com.jesse.financeapp.Activities.introActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jesse.financeapp.Activities.introActivity.screens.IntroScreen
import com.jesse.financeapp.MainActivity
import com.jesse.financeapp.R

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