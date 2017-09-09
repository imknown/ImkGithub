package net.imknown.imkgithub.mvp

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder

open class BaseActivity : AppCompatActivity() {
    lateinit var unbinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        unbinder = ButterKnife.bind(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        unbinder.unbind()
    }
}