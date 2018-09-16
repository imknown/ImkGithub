package net.imknown.imkgithub.buz.main

import io.reactivex.disposables.Disposable
import net.imknown.imkgithub.web.RetrofitFactory
import net.imknown.imkgithub.web.url.OtherMiscUrl

class MainMvpPresenter(val mvpView: MainMvpContract.IView) : MainMvpContract.IPresenter {
    // override var mvpViewWr = WeakReference(mvpView)

    override lateinit var disposable: Disposable

    override fun fetchZen() {
        disposable = RetrofitFactory.create<OtherMiscUrl>(String::class)
                .getZen()
                .compose(RetrofitFactory.ioToMain())
                .subscribe({
                    mvpView.showZen(it)
                }, {
                    it.printStackTrace()
                })
    }
}
