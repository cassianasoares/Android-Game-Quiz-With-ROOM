package com.demo.android.cassianasoares.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val waitHandler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        waitHandler.postDelayed(Runnable {
            try {

                //Go to next page i.e, start the next activity.
                startActivity(Intent(this, MainActivity::class.java))

                //Let's Finish Splash Activity since we don't want to show this when user press back button.
                finish()
            } catch (ignored: Exception) {
                ignored.printStackTrace()
            }
        }, 2000) // Give a 2 seconds delay.

    }

    override fun onDestroy() {
        super.onDestroy()
        waitHandler.removeCallbacksAndMessages(null)
    }

}
