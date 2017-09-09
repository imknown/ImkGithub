package net.imknown.imkgithub.mvp


import java.lang.ref.WeakReference

abstract class BaseMvpPresenterImpl<MvpView : BaseMvpView> : BaseMvpPresenter<MvpView> {
    private lateinit var mvpViewRef: WeakReference<MvpView>

    override fun attachView(mvpView: MvpView) {
        this.mvpViewRef = WeakReference(mvpView)
    }

    override fun detachView() {
        this.mvpViewRef.clear()
    }

    override fun getViewRef(): WeakReference<MvpView> {
        return mvpViewRef
    }
}