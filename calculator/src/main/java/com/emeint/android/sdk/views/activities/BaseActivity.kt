package com.emeint.android.sdk.views.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emeint.android.sdk.R

class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        Toast.makeText(this, "HERE you ARE", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
    }
}