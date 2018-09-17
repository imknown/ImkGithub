package net.imknown.imkgithub.global

import androidx.fragment.app.Fragment
import com.umeng.analytics.MobclickAgent
import net.imknown.imkgithub.mvp.IMvpView

abstract class BaseFragment : Fragment(), IMvpView {

    override fun onResume() {
        super.onResume()

        MobclickAgent.onPageStart(javaClass.name)
    }

    override fun onPause() {
        super.onPause()

        MobclickAgent.onPageEnd(javaClass.name)
    }
}