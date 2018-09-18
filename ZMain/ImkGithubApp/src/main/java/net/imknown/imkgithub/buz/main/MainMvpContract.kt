package net.imknown.imkgithub.buz.main

import net.imknown.imkgithub.mvp.IMvpPresenter
import net.imknown.imkgithub.mvp.IMvpView
import net.imknown.imkgithub.web.url.UserUrl

interface MainMvpContract {
    interface IView : IMvpView {
        fun showZen(zen: String)
        fun showAvatar(userInfo: UserUrl.UserInfo)
    }

    interface IPresenter : IMvpPresenter<IView> {
        fun fetchZen()
        fun fetchAvatar()
    }
}
