package com.example.sandymeliyawan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var BtnCrud : Button
    private lateinit var BtnCalc : Button
    private lateinit var BtnTextToSpeach : Button
    private lateinit var Profile : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnCrud = findViewById(R.id.btnCrud)
        BtnCalc = findViewById(R.id.btnKalkulator)
        BtnTextToSpeach = findViewById(R.id.btnTextToSpeach)
        Profile = findViewById(R.id.profile)

        BtnCrud.setOnClickListener{
            val intent = Intent(this,RoomActivity::class.java)
            startActivity(intent)
        }
        Profile.setOnClickListener{
            val intent = Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }
        BtnCalc.setOnClickListener{
            val intent = Intent(this,KalkulatorActivity::class.java)
            startActivity(intent)
        }
        BtnTextToSpeach.setOnClickListener{
            val intent = Intent(this,TextToSpeachActivity::class.java)
            startActivity(intent)
        }

    }
}