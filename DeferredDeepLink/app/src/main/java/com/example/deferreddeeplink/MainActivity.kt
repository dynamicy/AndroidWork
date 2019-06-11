package com.example.deferreddeeplink

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.branch.referral.Branch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        // Branch init
        Branch.getInstance().initSession({ referringParams, error ->
            if (error == null) {
                Log.i("BRANCH SDK", referringParams.toString())
            } else {
                Log.i("BRANCH SDK", error.message)
            }
        }, this.intent.data, this)
    }

    override fun onNewIntent(intent: Intent) {
        this.intent = intent
    }
}