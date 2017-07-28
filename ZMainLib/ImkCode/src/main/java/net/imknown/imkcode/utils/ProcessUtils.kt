package net.imknown.imkcode.utils

import android.app.ActivityManager
import android.content.Context
import android.os.Process
import android.text.TextUtils

object ProcessUtils {
    @JvmField val TAG: String = ProcessUtils::class.java.simpleName

    @JvmStatic fun isDefaultProcess(context: Context): Boolean {
        var isMain = false

        val processName = getCurrentProcessName(context)
        val packageName = context.packageName

        if (!TextUtils.isEmpty(processName)) {
            if (processName == packageName) {
                isMain = true
            }
        }

        return isMain
    }

    @JvmStatic fun getCurrentProcessName(context: Context): String {
        val currentPid = Process.myPid()

        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        activityManager.runningAppProcesses.forEach {
            if (currentPid == it.pid) {
                return it.processName
            }
        }

        return ""
    }
}
