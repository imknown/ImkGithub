package net.imknown.imkgithub.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseMvpPresenterFragment<MvpView : IMvpView, MvpPresenter : IMvpPresenter<MvpView>> : BaseFragment(), IMvpView {

    lateinit var mPresenter: MvpPresenter

    abstract fun initPresenter(): MvpPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        mPresenter = initPresenter()

        return view
    }

    override fun showMessage(@MessageTypeDef messageType: Int, message: String) {
        (activity as? BaseMvpPresenterActivity<*, *>)?.showMessage(messageType, message)
    }
}