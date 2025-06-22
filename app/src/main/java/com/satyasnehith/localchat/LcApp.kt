package com.satyasnehith.localchat

import android.app.Application
import timber.log.Timber

class LcApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}