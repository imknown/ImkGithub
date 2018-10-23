package net.imknown.imkgithub.global

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.squareup.leakcanary.LeakCanary
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
import net.imknown.imkcode.utils.ProcessUtils
import net.imknown.imkgithub.BuildConfig

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)
                || !ProcessUtils.isDefaultProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        application = this

        initDebugConfig()

        initUmeng()
    }

    open fun initUmeng() {
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null)
        UMConfigure.setLogEnabled(BuildConfig.DEBUG)
        UMConfigure.setEncryptEnabled(true)
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL)
        MobclickAgent.openActivityDurationTrack(false)
        // MobclickAgent.setSessionContinueMillis(30_000)
        // MobclickAgent.setSecret(this, "")
        // MobclickAgent.setCatchUncaughtExceptions(true)
    }

    open fun initDebugConfig() {}

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var application: Context
    }
}