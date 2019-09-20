package net.imknown.imkgithub.buz.main

import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import net.imknown.imkgithub.R
import net.imknown.imkgithub.global.GlideApp
import net.imknown.imkgithub.mvp.BaseMvpPresenterActivity
import net.imknown.imkgithub.web.url.UserUrl

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

    override fun componentInject() = activityComponent.inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        mPresenter.fetchZen()
        mPresenter.fetchAvatar()
    }

    override fun showZen(zen: String) {
        Toast.makeText(this, "Github Zen:\n$zen", Toast.LENGTH_LONG).show()
    }

    override fun showAvatar(userInfo: UserUrl.UserInfo) {
        message.text = userInfo.name

        GlideApp.with(this)
            .load(userInfo.avatarUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher_round)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(ivAvatar)
    }
}
