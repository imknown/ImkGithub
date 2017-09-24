package net.imknown.imkgithub.mvp

import android.support.annotation.IntDef

/**
 * @author Jinhe on 5/15/17.
 */

interface BaseMvpView {
    object MessageType {
        const val Toast = 0x01L
    }

    fun showMessage(@MessageTypeDef messageType: Long, message: String)
}

@IntDef(BaseMvpView.MessageType.Toast)
@Retention(AnnotationRetention.SOURCE)
annotation class MessageTypeDef