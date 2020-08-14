package com.stefany.plazyconf.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.stefany.plazyconf.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val  animation = AnimationUtils.loadAnimation(this,R.anim.animation)
        ivLogoPlatzyConf.startAnimation(animation)

        val intent = Intent(this,MainActivity::class.java)

        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                startActivity(intent)
                finish() //se destruye la pantalla
            }

            override fun onAnimationStart(p0: Animation?) {

            }

        })

    }
}