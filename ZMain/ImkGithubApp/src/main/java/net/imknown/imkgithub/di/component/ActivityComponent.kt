package net.imknown.imkgithub.di.component

import dagger.Component
import net.imknown.imkgithub.buz.SplashActivity
import net.imknown.imkgithub.buz.main.MainActivity
import net.imknown.imkgithub.di.module.ActivityModule
import net.imknown.imkgithub.di.scope.ActivityScope

@ActivityScope
@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(splashActivity: SplashActivity)
}