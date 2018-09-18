package net.imknown.imkgithub.buz.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.imknown.imkgithub.web.RetrofitFactory
import net.imknown.imkgithub.web.url.OtherMiscUrl
import net.imknown.imkgithub.web.url.UserUrl
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

    override fun fetchAvatar() {
        attachView(RetrofitFactory.create<UserUrl>()
                .getUserInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    iViewWr.get()?.showAvatar(it)
                }, {
                    it.printStackTrace()
                }))
    }
}
