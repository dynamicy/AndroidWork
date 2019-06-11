package com.example.deferreddeeplink

import android.app.Application
import io.branch.referral.Branch

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Branch logging for debugging
        Branch.enableLogging()

        // Branch object initialization
        Branch.getAutoInstance(this)
    }
}