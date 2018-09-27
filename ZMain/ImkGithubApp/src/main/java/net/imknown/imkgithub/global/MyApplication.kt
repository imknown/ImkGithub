package net.imknown.imkgithub.global

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import com.github.moduth.blockcanary.BlockCanary
import com.squareup.leakcanary.LeakCanary
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
import net.imknown.imkcode.utils.ProcessUtils
import net.imknown.imkgithub.BuildConfig

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        if (ProcessUtils.isDefaultProcess(this)) {
            application = this

            LeakCanary.install(this)
            BlockCanary.install(this, AppBlockCanaryContext()).start()
            // BlockCanaryEx.install(Config(this))

            Stetho.initializeWithDefaults(this)

            // region [友盟]
            UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null)
            UMConfigure.setLogEnabled(BuildConfig.DEBUG)
            UMConfigure.setEncryptEnabled(true)
            MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL)
            MobclickAgent.openActivityDurationTrack(false)
            // MobclickAgent.setSessionContinueMillis(30_000)
            // MobclickAgent.setSecret(this, "")
            // MobclickAgent.setCatchUncaughtExceptions(true)
            // endregion [友盟]
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var application: Context
    }
}