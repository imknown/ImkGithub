package net.imknown.imkgithub.module.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.imknown.imkgithub.web.Factory
import net.imknown.imkgithub.web.url.OtherMiscUrl

class MainMvpPresenter(mvpView: MainMvpContract.View) : MainMvpContract.Presenter() {
    init {
        attachView(mvpView)
    }

    override fun fetchZen() {
        Factory.create<OtherMiscUrl>(String::class)
                .getZen()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val mvpView = mvpViewRef.get()
                    mvpView?.showZen(it)
                }, {
                    it.printStackTrace()
                })
    }
}
