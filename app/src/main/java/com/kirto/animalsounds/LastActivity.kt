package com.kirto.animalsounds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import java.util.*

class LastActivity : AppCompatActivity() {
    lateinit var bTTs: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        bTTs= TextToSpeech(this, TextToSpeech.OnInitListener { status ->
            if (status!= TextToSpeech.ERROR)
            { bTTs.language= Locale.ENGLISH
                bTTs.speak("Congratulations! You're the best! Press the cup to play again.",TextToSpeech.QUEUE_FLUSH,null)}
        })
    }

    fun pressCup(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}