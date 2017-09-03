package net.imknown.imkgithub.module.main

import net.imknown.imkgithub.mvp.BaseMvpPresenterImpl
import net.imknown.imkgithub.mvp.BaseMvpView

interface MainMvpContract {
    interface View : BaseMvpView {
        fun showZen(zen: String)
    }

    abstract class Presenter : BaseMvpPresenterImpl<View>() {
        abstract fun fetchZen()
    }
}
