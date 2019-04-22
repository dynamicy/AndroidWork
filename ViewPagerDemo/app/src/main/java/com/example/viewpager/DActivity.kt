package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
    }

    override fun onPause() {
        super.onPause()

        println()
    }
}
