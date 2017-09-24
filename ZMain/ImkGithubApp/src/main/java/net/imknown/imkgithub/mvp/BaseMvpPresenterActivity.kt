package net.imknown.imkgithub.mvp

import org.jetbrains.anko.toast

abstract class BaseMvpPresenterActivity : BaseActivity(), BaseMvpView {

    override fun showMessage(@MessageTypeDef messageType: Long, message: String) {
        if (messageType == BaseMvpView.MessageType.Toast) {
            toast(message)
        }
    }
}
