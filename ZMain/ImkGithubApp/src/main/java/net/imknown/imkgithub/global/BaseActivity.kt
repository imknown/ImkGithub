package net.imknown.imkgithub.global

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umeng.analytics.MobclickAgent
import net.imknown.imkgithub.di.component.ActivityComponent
import net.imknown.imkgithub.di.component.DaggerActivityComponent
import net.imknown.imkgithub.di.module.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    protected val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent(MyApplication.applicationComponent)
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        componentInject()
    }

    abstract fun componentInject()

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