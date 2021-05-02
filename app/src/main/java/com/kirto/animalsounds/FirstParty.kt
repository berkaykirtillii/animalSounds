package com.kirto.animalsounds


import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_first_party.*
import java.util.*


class FirstParty : AppCompatActivity() {
    lateinit var bTTs: TextToSpeech
    var mediaPlayer:MediaPlayer?=null
    lateinit var sharedPreferences:SharedPreferences
    var highscore: Int?= null
    private lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_party)

        sharedPreferences=this.getSharedPreferences("com.kirto.animalsounds",Context.MODE_PRIVATE)
        highscore= sharedPreferences.getInt("highskor",0)
        textHigh.text= "High Score ${highscore}"

        mediaPlayer = MediaPlayer.create(this,R.raw.kopeksesi)
        mediaPlayer?.start()

        timer= object : CountDownTimer(22000,1000){
            override fun onTick(millisUntilFinished: Long) {
                if ((millisUntilFinished/1000)-2 >= 0){
               textKalan.text= "Time : ${(millisUntilFinished/1000)-2} sec"
                }
            }

            override fun onFinish() {
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
                finish()
            }


        }.start()

    }
    override fun onBackPressed() {
        super.onBackPressed()
        timer.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onStart() {
        super.onStart()
        bTTs= TextToSpeech(this, TextToSpeech.OnInitListener { status ->
            if (status!= TextToSpeech.ERROR)
            { bTTs.language= Locale.ENGLISH
                bTTs.speak("dog",TextToSpeech.QUEUE_FLUSH,null)}
        })

    }

    fun playturtlefordog(view: View) {

        bTTs.speak("Sorry, you chose the wrong animal.Press the button to start over.",TextToSpeech.QUEUE_FLUSH,null)

        val cikisMesaji = AlertDialog.Builder(this)
        cikisMesaji.setMessage("Sorry, you chose the wrong animal.Press the button to start over.")
        cikisMesaji.setPositiveButton("Start Again", DialogInterface.OnClickListener { dialog, which ->
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        })

        cikisMesaji.show()

    }


    fun playdog(view: View) {

        val kullaniciSkor= 1
        sharedPreferences.edit().putInt("skor",kullaniciSkor).apply()
        textSkor.text = "SCORE ${kullaniciSkor}"
        if (kullaniciSkor >  highscore!!){
            sharedPreferences.edit().putInt("highskor",kullaniciSkor).apply()
        }
        bTTs.speak("CONGRATULATIONS!",TextToSpeech.QUEUE_FLUSH,null)



        object : CountDownTimer(2000,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                val intent = Intent(applicationContext,SecondParty::class.java)
                startActivity(intent)
                finish()
            }

        }.start()

    }

    fun listenAgain1(view: View) {
        mediaPlayer?.start()
    }

}