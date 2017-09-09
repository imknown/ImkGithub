package net.imknown.imkgithub.mvp

import java.lang.ref.WeakReference

/**
 * @author Jinhe on 5/15/17.
 */

interface BaseMvpPresenter<MvpView : BaseMvpView> {
    fun attachView(mvpView: MvpView)

    fun getViewRef(): WeakReference<MvpView>

    fun detachView()
}
