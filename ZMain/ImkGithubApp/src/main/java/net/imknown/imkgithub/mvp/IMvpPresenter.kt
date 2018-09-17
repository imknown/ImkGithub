package net.imknown.imkgithub.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

interface IMvpPresenter<MvpView : IMvpView> {
    var iViewWr: WeakReference<MvpView>

    private val compositeDisposable: CompositeDisposable
        get() = CompositeDisposable()

    fun attachView(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun detachView() {
        iViewWr.clear()

        compositeDisposable.clear()
    }
}
