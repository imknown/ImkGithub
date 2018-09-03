package net.imknown.imkgithub.mvp

import androidx.annotation.IntDef

/**
 * @author Jinhe on 5/15/17.
 */

interface BaseMvpView {
    object MessageType {
        const val Toast = 0x01
    }

    fun showMessage(@MessageTypeDef messageType: Int, message: String)
}

@IntDef(BaseMvpView.MessageType.Toast)
@Retention(AnnotationRetention.SOURCE)
annotation class MessageTypeDef