package com.kirto.animalsounds


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun StartButton(view: View) {

        val intent = Intent(applicationContext,FirstParty::class.java)
        startActivity(intent)
        finish()

    }
}