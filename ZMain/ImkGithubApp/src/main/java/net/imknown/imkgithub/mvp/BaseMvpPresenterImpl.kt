package net.imknown.imkgithub.mvp


import java.lang.ref.WeakReference

abstract class BaseMvpPresenterImpl<MvpView : BaseMvpView> : BaseMvpPresenter<MvpView> {
    protected lateinit var mvpViewRef: WeakReference<MvpView>
        private set

    protected fun attachView(mvpView: MvpView) {
        this.mvpViewRef = WeakReference(mvpView)
    }

    protected fun detachView() {
        this.mvpViewRef.clear()
    }
}