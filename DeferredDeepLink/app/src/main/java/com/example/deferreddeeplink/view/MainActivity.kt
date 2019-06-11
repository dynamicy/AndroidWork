package com.example.deferreddeeplink.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.deferreddeeplink.R
import io.branch.referral.Branch
import io.branch.referral.Branch.BranchReferralInitListener
import io.branch.referral.BranchError
import org.json.JSONObject

class MainActivity : AppCompatActivity(), BranchReferralInitListener {

    private val tag: String = MainActivity::javaClass.name

    override fun onInitFinished(referringParams: JSONObject?, error: BranchError?) {
        Log.i(tag, "onInitFinished")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val branch = Branch.getInstance()

        // Branch init
        branch.initSession({ referringParams, error ->
            if (error == null) {
                Log.i("BRANCH SDK", referringParams.toString())

                when (referringParams.optString("~id", "")) {
                    "" -> startActivity(Intent(this, SlaveActivity::class.java))
                    "666902580601505944" -> startActivity(Intent(this, ChildActivity::class.java))
                    "666866886290084734" -> startActivity(Intent(this, AnotherActivity::class.java))
                }
            } else {
                Log.i("BRANCH SDK", error.message)
            }
        }, this.intent.data, this)
    }

    override fun onNewIntent(intent: Intent) {
        this.intent = intent

        this.intent.let {
            val myIntent = it

            val action = myIntent.action
            val data = myIntent.data

            Log.i("Action: ", action.toString())
            Log.i("Data: ", data.toString())
        }
    }
}