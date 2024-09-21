package br.com.mgonzaga.orgs.ui.acivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.mgonzaga.orgs.R

class AndroidLifeCircleActivity : AppCompatActivity() {
    private var createCount = 0
    private var startCount = 0
    private var resumeCount = 0
    private var pauseCount = 0
    private var stopCount = 0
    private var restartCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_life_circle)
        createCount++
        updateLifeCyrcleStatus();
        val resetCount = findViewById<Button>(R.id.resetCount)
        resetCount.setOnClickListener {
            startCount = 0
            resumeCount = 0
            pauseCount = 0
            stopCount = 0
            restartCount = 0
            updateLifeCyrcleStatus()
        }
        val openProductList = findViewById<Button>(R.id.openNewActivity)
        openProductList.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun updateLifeCyrcleStatus() {
        val create = findViewById<TextView>(R.id.createCount)
        val start = findViewById<TextView>(R.id.startCount)
        val resume = findViewById<TextView>(R.id.resumeCount)
        val pause = findViewById<TextView>(R.id.pauseCount)
        val stop = findViewById<TextView>(R.id.stopCount)
        val restart = findViewById<TextView>(R.id.restartCount)

        create.text = "OnCreate: ${createCount}"
        start.text = "OnStart: ${startCount}"
        resume.text = "OnResume: ${resumeCount}"
        pause.text = "OnPause: ${pauseCount}"
        stop.text = "OnStop: ${stopCount}"
        restart.text = "OnRestart: ${restartCount}"

    }

    override fun onStart() {
        super.onStart()
        startCount++
        updateLifeCyrcleStatus()
    }

    override fun onResume() {
        super.onResume()
        resumeCount++
        updateLifeCyrcleStatus()
    }

    override fun onPause() {
        super.onPause()
        pauseCount++
        updateLifeCyrcleStatus()
    }

    override fun onStop() {
        super.onStop()
        stopCount++
        updateLifeCyrcleStatus()
    }

    override fun onRestart() {
        super.onRestart()
        restartCount++
        updateLifeCyrcleStatus()
    }
}