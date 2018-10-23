package net.imknown.imkgithub

import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import net.imknown.imkgithub.global.MyApplication

class MyDebugApplication : MyApplication() {
    override fun initDebugConfig() {
        super.initDebugConfig()

        LeakCanary.install(this)
        // BlockCanary.install(this, AppBlockCanaryContext()).start()
        // BlockCanaryEx.install(Config(this))

        Stetho.initializeWithDefaults(this)
    }
}