package net.imknown.imkgithub.mvp

import io.reactivex.disposables.Disposable

interface IMvpPresenter<MvpView : IMvpView> {
    // var mvpViewWr: WeakReference<MvpView>

    var disposable: Disposable

    fun detachView() {
        // mvpViewWr.clear()

        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}
