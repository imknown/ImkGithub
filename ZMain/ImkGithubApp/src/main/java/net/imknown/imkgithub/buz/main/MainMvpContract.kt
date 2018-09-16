package net.imknown.imkgithub.buz.main

import net.imknown.imkgithub.mvp.IMvpPresenter
import net.imknown.imkgithub.mvp.IMvpView

interface MainMvpContract {
    interface IView : IMvpView {
        fun showZen(zen: String)
    }

    interface IPresenter : IMvpPresenter<IView> {
        fun fetchZen()
    }
}
