package net.imknown.imkgithub.global

import android.app.Application
import android.content.Context
import com.github.moduth.blockcanary.BlockCanary
import com.letv.sarrsdesktop.blockcanaryex.jrt.BlockCanaryEx
import com.letv.sarrsdesktop.blockcanaryex.jrt.Config
import com.squareup.leakcanary.LeakCanary
import net.imknown.imkcode.utils.ProcessUtils

/**
 * @author imknown on 8/9/17.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }

        if (ProcessUtils.isDefaultProcess(this)) {
            sApplicationContext = applicationContext

            LeakCanary.install(this)
            BlockCanary.install(this, AppBlockCanaryContext()).start()
            BlockCanaryEx.install(Config(this))
        }
    }

    companion object {
        lateinit var sApplicationContext: Context
    }
}