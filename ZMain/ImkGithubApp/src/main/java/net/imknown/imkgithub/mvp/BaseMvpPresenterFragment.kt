package net.imknown.imkgithub.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.imknown.imkgithub.global.BaseFragment
import javax.inject.Inject

abstract class BaseMvpPresenterFragment<MvpView : IMvpView, MvpPresenter : IMvpPresenter<MvpView>> : BaseFragment(), IMvpView {

    @Inject
    protected lateinit var mPresenter: MvpPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        componentInject()

        return view
    }

    override fun showMessage(@MessageTypeDef messageType: Int, message: String) {
        (activity as? BaseMvpPresenterActivity<*, *>)?.showMessage(messageType, message)
    }

    override fun onDetach() {
        mPresenter.detachView()

        super.onDetach()
    }
}