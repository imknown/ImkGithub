package net.imknown.imkgithub.buz.main

import net.imknown.imkgithub.web.RetrofitFactory
import net.imknown.imkgithub.web.url.OtherMiscUrl
import java.lang.ref.WeakReference

class MainMvpPresenter(iView: MainMvpContract.IView) : MainMvpContract.IPresenter {
    override var iViewWr = WeakReference(iView)

    override fun fetchZen() {
        attachView(RetrofitFactory.create<OtherMiscUrl>(String::class)
                .getZen()
                .compose(RetrofitFactory.ioToMain())
                .subscribe({
                    iViewWr.get()?.showZen(it)
                }, {
                    it.printStackTrace()
                }))
    }
}
