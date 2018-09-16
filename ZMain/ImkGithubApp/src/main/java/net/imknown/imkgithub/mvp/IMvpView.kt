package net.imknown.imkgithub.mvp

interface IMvpView {
    fun showMessage(@MessageTypeDef messageType: Int, message: String)
}