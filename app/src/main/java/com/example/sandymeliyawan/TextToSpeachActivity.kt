package com.example.sandymeliyawan

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TextToSpeachActivity : AppCompatActivity() {

    private lateinit var userText: EditText
    private lateinit var b1: Button
    private lateinit var imageView: ImageView
    private lateinit var t1: TextToSpeech
    private lateinit var userToSpeak: String

    private val REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speach)

        userText = findViewById(R.id.userText)
        b1 = findViewById(R.id.button)
        imageView = findViewById(R.id.imageMic)

        t1 = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR) {
                t1.language = Locale.UK
            }
        })

        b1.setOnClickListener {
            userToSpeak = userText.text.toString()
            if (userToSpeak.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter your text", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, userToSpeak, Toast.LENGTH_SHORT).show()
                t1.speak(userToSpeak, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }

        imageView.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something")

            try {
                startActivityForResult(intent, REQUEST_CODE)
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "Sorry! Your device does not support speech input.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE -> {
                if (resultCode == RESULT_OK && data != null) {
                    val res = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    userText.setText(res?.get(0))
                    Toast.makeText(applicationContext, res?.get(0), Toast.LENGTH_SHORT).show()
                    t1.speak(res?.get(0), TextToSpeech.QUEUE_FLUSH, null, null)
                }
            }
        }
    }

    override fun onDestroy() {
        // Don't forget to shutdown!
        if (::t1.isInitialized) {
            t1.stop()
            t1.shutdown()
        }
        super.onDestroy()
    }
}
