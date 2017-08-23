package net.imknown.imkgithub.mvp

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseMvpPresenterActivity : AppCompatActivity(), BaseMvpView {
    lateinit var unbinder: Unbinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        unbinder = ButterKnife.bind(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        unbinder.unbind()
    }

    override fun showMessage(messageType: BaseMvpView.MessageType, message: String) {
        if (messageType === BaseMvpView.MessageType.Toast) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
