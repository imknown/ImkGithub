package net.imknown.imkgithub.di.component

import dagger.Component
import net.imknown.imkgithub.di.module.ApplicationModule
import net.imknown.imkgithub.di.scope.ApplicationScope
import net.imknown.imkgithub.global.MyApplication
import javax.inject.Singleton

@ApplicationScope
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(myApplication: MyApplication)
}
