package net.imknown.imkgithub.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import net.imknown.imkgithub.buz.main.MainMvpContract
import net.imknown.imkgithub.buz.main.MainMvpPresenter

@Module
class ActivityModule(private val mActivity: Activity) {
    // region [Main]
    @Provides
    internal fun provideMainMvpContractIPresenter(presenter: MainMvpPresenter): MainMvpContract.IPresenter = presenter

    @Provides
    internal fun provideMainMvpContractIView() = mActivity as MainMvpContract.IView

    // @Provides
    // internal fun provideMainMvpPresenter(iView: MainMvpContract.IView) = MainMvpPresenter(iView)
    // endregion [Main]
}