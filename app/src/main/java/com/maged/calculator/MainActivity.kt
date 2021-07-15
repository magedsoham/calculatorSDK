package com.maged.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.emeint.android.sdk.`interface`.CalculatorSdk

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
        CalculatorSdk.startPaymentActivity(this)

    }
}