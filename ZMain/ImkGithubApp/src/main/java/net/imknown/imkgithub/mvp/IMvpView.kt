package net.imknown.imkgithub.mvp

interface IMvpView {
    fun componentInject()

    fun showMessage(@MessageTypeDef messageType: Int, message: String)
}