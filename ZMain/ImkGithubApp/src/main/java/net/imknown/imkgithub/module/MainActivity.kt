package net.imknown.imkgithub.module

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import net.imknown.imkgithub.R
import net.imknown.imkgithub.web.Factory
import net.imknown.imkgithub.web.url.OtherMiscUrl
import net.imknown.imkgithub.web.url.UserUrl
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        Factory.create<UserUrl>()
                .getUserInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    message.text = it.name

                    Glide.with(this)
                            .load(it.avatarUrl)
                            .apply(RequestOptions()
                                    .placeholder(R.mipmap.ic_launcher)
                                    .error(R.mipmap.ic_launcher_round))
                            .transition(DrawableTransitionOptions.withCrossFade(android.R.anim.fade_in, 300))
                            .into(ivAvatar)
                }, {
                    it.printStackTrace()
                })

        Factory.create<OtherMiscUrl>(String::class)
                .getZen()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    longToast("Github Zen:" + "\n" + it)
                }, {
                    it.printStackTrace()
                })
    }
}
