package net.imknown.imkgithub.buz

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import net.imknown.imkgithub.R
import net.imknown.imkgithub.buz.main.MainActivity
import net.imknown.imkgithub.mvp.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isBroughtToFront) {
            finish()
            return
        }

        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            finish()
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }, 2000)
    }

    private val isBroughtToFront: Boolean
        get() = intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0
}