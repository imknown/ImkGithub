package net.imknown.imkgithub.mvp

import net.imknown.imkgithub.global.BaseFragment
import javax.inject.Inject

abstract class BaseMvpPresenterFragment<MvpView : IMvpView, MvpPresenter : IMvpPresenter<MvpView>> : BaseFragment(), IMvpView {

    @Inject
    protected lateinit var mPresenter: MvpPresenter

    override fun showMessage(@MessageTypeDef messageType: Int, message: String) {
        (activity as? BaseMvpPresenterActivity<*, *>)?.showMessage(messageType, message)
    }

    override fun onDetach() {
        mPresenter.detachView()

        super.onDetach()
    }
}