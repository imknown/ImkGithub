package net.imknown.imkgithub.mvp

import android.os.Bundle
import org.jetbrains.anko.toast

abstract class BaseMvpPresenterActivity : BaseActivity(), BaseMvpView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun showMessage(messageType: BaseMvpView.MessageType, message: String) {
        if (messageType === BaseMvpView.MessageType.Toast) {
            toast(message)
        }
    }
}
