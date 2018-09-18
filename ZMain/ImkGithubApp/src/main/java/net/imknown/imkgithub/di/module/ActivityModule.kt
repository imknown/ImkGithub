package net.imknown.imkgithub.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import net.imknown.imkgithub.buz.main.MainActivity
import net.imknown.imkgithub.buz.main.MainMvpContract
import net.imknown.imkgithub.buz.main.MainMvpPresenter

@Module
class ActivityModule(private val mActivity: Activity) {
    // region [Main]
    @Provides
    internal fun provideMainMvpContractIView(): MainMvpContract.IView = mActivity as MainActivity

    @Provides
    internal fun provideMainMvpContractIPresenter(iView: MainMvpContract.IView): MainMvpContract.IPresenter = MainMvpPresenter(iView)
    // endregion [Main]
}