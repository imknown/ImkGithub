package net.imknown.imkgithub.buz

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash.*
import net.imknown.imkgithub.R
import net.imknown.imkgithub.buz.main.MainActivity
import net.imknown.imkgithub.global.BaseActivity
import org.jetbrains.anko.sdk25.coroutines.onClick

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isBroughtToFront) {
            finish()
            return
        }

        setContentView(R.layout.activity_splash)

        tvLogo.onClick {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }

//        Handler().postDelayed({
//            finish()
//            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
//        }, 2000)
    }

    private val isBroughtToFront
        get() = intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0
}
