package net.imknown.imkgithub.buz.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import net.imknown.imkgithub.R
import net.imknown.imkgithub.mvp.BaseMvpPresenterActivity
import org.jetbrains.anko.longToast

class MainActivity : BaseMvpPresenterActivity<MainMvpContract.IView, MainMvpContract.IPresenter>(), MainMvpContract.IView {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun initPresenter() = MainMvpPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

//        RetrofitFactory.create<UserUrl>()
//                .getUserInfo()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe({
//                    message.text = it.name
//
//                    GlideApp.with(this)
//                            .load(it.avatarUrl)
//                            .placeholder(R.mipmap.ic_launcher)
//                            .error(R.mipmap.ic_launcher_round)
//                            .transition(DrawableTransitionOptions.withCrossFade())
//                            .into(ivAvatar)
//                }, {
//                    it.printStackTrace()
//                })

        mPresenter.fetchZen()
    }

    override fun showZen(zen: String) {
        longToast("Github Zen:\n$zen")
    }
}
