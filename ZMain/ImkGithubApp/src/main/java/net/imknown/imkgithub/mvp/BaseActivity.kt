package net.imknown.imkgithub.mvp

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umeng.analytics.MobclickAgent

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onResume() {
        super.onResume()

        if (supportFragmentManager.fragments.size == 0) {
            MobclickAgent.onPageStart(javaClass.name)
        }
        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()

        if (supportFragmentManager.fragments.size == 0) {
            MobclickAgent.onPageEnd(javaClass.name)
        }
        MobclickAgent.onPause(this)
    }
}