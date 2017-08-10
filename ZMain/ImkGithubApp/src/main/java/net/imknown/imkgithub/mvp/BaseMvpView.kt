package net.imknown.imkgithub.mvp

/**
 * @author Jinhe on 5/15/17.
 */

interface BaseMvpView {
    enum class MessageType {
        Toast
    }

    fun showMessage(messageType: MessageType, message: String)
}
