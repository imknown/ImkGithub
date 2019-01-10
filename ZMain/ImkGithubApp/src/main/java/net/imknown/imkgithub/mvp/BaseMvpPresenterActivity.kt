package net.imknown.imkgithub.mvp

import net.imknown.imkgithub.global.BaseActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract class BaseMvpPresenterActivity<MvpView : IMvpView, MvpPresenter : IMvpPresenter<MvpView>> : BaseActivity(),
    IMvpView {

    @Inject
    protected lateinit var mPresenter: MvpPresenter

    override fun showMessage(@MessageTypeDef messageType: Int, message: String) {
        if (messageType == MessageType.Toast) {
            toast(message)
        }
    }

    override fun onDestroy() {
        mPresenter.detachView()

        super.onDestroy()
    }
}
