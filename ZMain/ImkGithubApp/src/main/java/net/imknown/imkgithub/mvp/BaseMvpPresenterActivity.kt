package net.imknown.imkgithub.mvp

import android.os.Bundle
import org.jetbrains.anko.toast

abstract class BaseMvpPresenterActivity<MvpView : IMvpView, MvpPresenter : IMvpPresenter<MvpView>> : BaseActivity(), IMvpView {

    protected lateinit var mPresenter: MvpPresenter

    abstract fun initPresenter(): MvpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = initPresenter()
    }

    override fun showMessage(@MessageTypeDef messageType: Int, message: String) {
        if (messageType == MessageType.Toast) {
            toast(message)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mPresenter.detachView()
    }
}
