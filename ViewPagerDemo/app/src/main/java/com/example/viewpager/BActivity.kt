package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }

    override fun onPause() {
        super.onPause()

        println()
    }
}
