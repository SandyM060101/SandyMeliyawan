package com.example.sandymeliyawan


// SplashActivity.kt
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 5000 // 5 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Intent untuk beralih ke MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // menutup SplashActivity agar tidak bisa kembali
        }, SPLASH_TIME_OUT)
    }
}