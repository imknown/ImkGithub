package net.imknown.imkgithub.mvp


import java.lang.ref.WeakReference

abstract class BaseMvpPresenterImpl<MvpView : BaseMvpView>(mvpView: MvpView) : WeakReference<MvpView>(mvpView), BaseMvpPresenter<MvpView> {

    protected var mvpViewRef: WeakReference<MvpView>? = null
        private set

    protected fun attachView(mvpView: MvpView) {
        this.mvpViewRef = WeakReference(mvpView)
    }

    protected fun detachView() {
        super.clear()
    }
}