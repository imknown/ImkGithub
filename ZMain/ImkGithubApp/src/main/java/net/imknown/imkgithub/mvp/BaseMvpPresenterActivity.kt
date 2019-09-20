package net.imknown.imkgithub.mvp

import android.widget.Toast
import net.imknown.imkgithub.global.BaseActivity
import javax.inject.Inject

abstract class BaseMvpPresenterActivity<MvpView : IMvpView, MvpPresenter : IMvpPresenter<MvpView>> :
    BaseActivity(),
    IMvpView {

    @Inject
    protected lateinit var mPresenter: MvpPresenter

    override fun showMessage(@MessageTypeDef messageType: Int, message: String) {
        if (messageType == MessageType.Toast) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        mPresenter.detachView()

        super.onDestroy()
    }
}
