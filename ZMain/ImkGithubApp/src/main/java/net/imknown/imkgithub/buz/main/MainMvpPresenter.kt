package net.imknown.imkgithub.buz.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import net.imknown.imkgithub.web.Factory
import net.imknown.imkgithub.web.url.OtherMiscUrl

class MainMvpPresenter(val mvpView: MainMvpContract.IView) : MainMvpContract.IPresenter {
    // override var mvpViewWr = WeakReference(mvpView)

    override lateinit var disposable: Disposable

    override fun fetchZen() {
        disposable = Factory.create<OtherMiscUrl>(String::class)
                .getZen()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    mvpView.showZen(it)
                }, {
                    it.printStackTrace()
                })
    }
}
