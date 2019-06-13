package net.imknown.imkgithub

import com.facebook.stetho.Stetho
import net.imknown.imkgithub.global.MyApplication

class MyDebugApplication : MyApplication() {
    override fun initDebugConfig() {
        super.initDebugConfig()

        // BlockCanary.install(this, AppBlockCanaryContext()).start()
        // BlockCanaryEx.install(Config(this))

        Stetho.initializeWithDefaults(this)
    }
}