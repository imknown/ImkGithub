package net.imknown.imkgithub.di.module

import dagger.Module
import dagger.Provides
import net.imknown.imkgithub.buz.main.MainActivity
import net.imknown.imkgithub.buz.main.MainMvpContract
import net.imknown.imkgithub.buz.main.MainMvpPresenter
import net.imknown.imkgithub.global.BaseActivity

@Module
class ActivityModule(private val mActivity: BaseActivity) {
    // region [Main]
    @Provides
    internal fun provideMainMvpContractIView(): MainMvpContract.IView = mActivity as MainActivity

    @Provides
    internal fun provideMainMvpContractIPresenter(iView: MainMvpContract.IView): MainMvpContract.IPresenter =
        MainMvpPresenter(iView)
    // endregion [Main]
}