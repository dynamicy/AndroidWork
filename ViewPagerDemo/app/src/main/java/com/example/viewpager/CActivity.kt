package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
    }

    override fun onPause() {
        super.onPause()

        println()
    }
}
