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
import kotlinx.android.synthetic.main.activity_twelfth_party.*
import java.util.*

class TwelfthParty : AppCompatActivity() {
    lateinit var bTTs: TextToSpeech
    var mediaPlayer: MediaPlayer?=null
    lateinit var sharedPreferences: SharedPreferences
    var highscore: Int?= null
    var kaydedilenskor: Int?= null
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twelfth_party)
        sharedPreferences=this.getSharedPreferences("com.kirto.animalsounds", Context.MODE_PRIVATE)
        kaydedilenskor= sharedPreferences.getInt("skor",0)
        textSkor12.text = "SCORE ${kaydedilenskor}"

        mediaPlayer = MediaPlayer.create(this,R.raw.monkeysound)


        timer=object : CountDownTimer(12000,1000){
            override fun onTick(millisUntilFinished: Long) {
                if ((millisUntilFinished/1000)-2 >= 0){
                    textKalan12.text= "Time : ${(millisUntilFinished/1000)-2} sec"}
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
            { bTTs.language= Locale.ENGLISH }
        })
        highscore= sharedPreferences.getInt("highskor",0)
        textHigh12.text= "High Score ${highscore}"
    }

    fun playmonkey3(view: View) {
        val kullaniciSkor = 12
        sharedPreferences.edit().putInt("skor", kullaniciSkor).apply()
        textSkor12.text = "SCORE ${kullaniciSkor}"
        if (kullaniciSkor > highscore!!) {
            sharedPreferences.edit().putInt("highskor", kullaniciSkor).apply()
        }
        bTTs.speak("Fantastic!", TextToSpeech.QUEUE_FLUSH,null)
        object : CountDownTimer(2000,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                val intent = Intent(applicationContext,ThirteenthParty::class.java)
                startActivity(intent)
                finish()
            }

        }.start()
    }
    fun playsnailformonkey(view: View) {
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
    fun playlionformonkey(view: View) {
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
    fun playbeeformonkey(view: View) {
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
    fun playdolphinformonkey(view: View) {
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
    fun playturtleformonkey(view: View) {
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
    fun listenAgain12(view: View) {
        mediaPlayer?.start()
    }
}