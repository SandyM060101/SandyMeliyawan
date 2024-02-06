package com.example.sandymeliyawan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class AboutActivity : AppCompatActivity() {
    private lateinit var BtnYoutube: ImageView
    private lateinit var BtnInstagram: ImageView
    private lateinit var BtnFacebook: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        BtnYoutube = findViewById(R.id.btnYoutube)
        BtnInstagram = findViewById(R.id.btnInstagram)
        BtnFacebook = findViewById(R.id.btnFacebook)

        BtnYoutube.setOnClickListener {
            val packageName = "com.google.android.youtube"
            val intent = packageManager.getLaunchIntentForPackage(packageName)
            if (intent != null) {
                startActivity(intent)
            } else {
                // Jika aplikasi YouTube tidak ditemukan, buka lewat browser
                val url = "https://www.youtube.com/@Start.Codding"
                val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intentBrowser)
            }
        }

        BtnInstagram.setOnClickListener {
            val packageName = "com.instagram.android"
            val intent = packageManager.getLaunchIntentForPackage(packageName)
            if (intent != null) {
                startActivity(intent)
            } else {
                // Aplikasi Instagram tidak ditemukan, tampilkan pesan kesalahan atau buka lewat browser
                Toast.makeText(this, "06.01.2001.2", Toast.LENGTH_SHORT).show()
                // Buka Instagram lewat browser
                val url = "https://www.instagram.com/06.01.2001.2/"
                val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intentBrowser)
            }
        }

        BtnFacebook.setOnClickListener {
            val packageName = "com.facebook.katana" // Ini adalah paket aplikasi Facebook
            val intent = packageManager.getLaunchIntentForPackage(packageName)
            if (intent != null) {
                startActivity(intent)
            } else {
                // Jika aplikasi Facebook tidak terpasang, buka Facebook lewat browser
                val url = "https://www.facebook.com/profile.php?id=100092970019053"
                val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intentBrowser)
            }
        }

    }
}