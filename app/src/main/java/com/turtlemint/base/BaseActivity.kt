package com.turtlemint.base

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.turtlemint.receivers.ConnectivityReceiver
import com.turtlemint.utils.Constants
import com.turtlemint.utils.Utility

open class BaseActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    var isConnected: Boolean = false
    private var connectivityReceiver: BroadcastReceiver = ConnectivityReceiver()


    private fun isAppOnForeground(context: Context): Boolean {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val appProcesses = activityManager.runningAppProcesses ?: return false
        val packageName = context.packageName
        for (appProcess in appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName == packageName) {
                return true
            }
        }

        return false
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        isConnected = ConnectivityReceiver().isConnectedOrConnecting(this@BaseActivity)

        registerReceiver(
            connectivityReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )

        showMessage(isConnected, true)
    }

    private fun showMessage(isConnected: Boolean, isFirstTime: Boolean) {
        if (!isConnected) {
            if (!isFirstTime && !this.isConnected) {
                return
            }

            Utility.showToast(this, Constants.NO_INTERNET)
        }else{
            Utility.showToast(this, Constants.INTERNET_CONNECT)
        }

        this.isConnected = isConnected
    }

    override fun onResume() {
        super.onResume()

        isAppOnForeground(this)

        ConnectivityReceiver.connectivityReceiverListener = this
    }

    override fun onDestroy() {
        super.onDestroy()

        if (null != registerReceiver(
                connectivityReceiver,
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
        )
            unregisterReceiver(connectivityReceiver)
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showMessage(isConnected, false)
    }
}