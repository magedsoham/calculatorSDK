package com.emeint.android.sdk.`interface`

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.emeint.android.sdk.views.activities.CalculatorActivity

object CalculatorSdk {

    fun startPaymentActivity(ctn: Context?) {
        if (ctn != null) {
            val intent = Intent(ctn, CalculatorActivity::class.java)
            (ctn as Activity?)?.startActivity(intent)
        }
    }
}