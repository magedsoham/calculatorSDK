package com.emeint.android.sdk.views.activities

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.emeint.android.sdk.databinding.ActivityBaseBinding
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*


class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    private var fullText: String = ""
    private var decimalClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {

        binding.btnClear.setOnClickListener {
            val stringTemp: String = binding.txtInput.text.toString().replace("AED ", "")
            if (stringTemp.isNotEmpty() && (stringTemp.last() == '.' || stringTemp.endsWith(".00")))
                decimalClicked = false
            if (stringTemp.endsWith(".00")) {
                var beforePoint = stringTemp.substring(0, stringTemp.indexOf('.'))
                val afterPoint =
                    stringTemp.substring(stringTemp.indexOf('.') + 1, stringTemp.length)
                beforePoint = beforePoint.dropLast(1)
                fullText = "$beforePoint.$afterPoint"
                if (beforePoint.isEmpty())
                    fullText = ""
            } else {
                fullText = stringTemp.dropLast(1)
            }
            setTextStyleFormatted(fullText)
        }
        binding.btnDecimal.setOnClickListener {

            if (!decimalClicked) {
                decimalClicked = true
                if (fullText.isEmpty()) {
                    fullText = "."
                }
                setTextStyleFormatted(fullText)
            }
        }
    }

    fun onDigit(view: View) {
        val stringTemp: String = binding.txtInput.text.toString().replace("AED ", "")
        if (stringTemp.contains(".")) {
            val beforePoint = stringTemp.substring(0, stringTemp.indexOf('.'))
            val afterPoint = stringTemp.substring(stringTemp.indexOf('.') + 1, stringTemp.length)
            if (afterPoint.isNotEmpty() && afterPoint.toBigDecimal() * BigDecimal(1) == BigDecimal(0) && !decimalClicked)
                fullText = beforePoint + (view as Button).text + "." + afterPoint
            else if (decimalClicked) {
                if (afterPoint != "00")
                    fullText = beforePoint + "." + afterPoint + (view as Button).text
                else
                    fullText = beforePoint + "." + (view as Button).text

            } else
                fullText += (view as Button).text
        } else
            fullText += (view as Button).text
        setTextStyleFormatted(fullText)
    }

    private fun getTextFormatted(text: String): String {
        if (text == ".")
            return "0.00"
        val currentLocale = Locale("en", "UAE")
        val unusualSymbols = DecimalFormatSymbols(currentLocale)
        var strange = "#,##0"
        if (!text.contains(".") || text.endsWith(".00") || text.endsWith("."))
            strange = "#,##0.00"
        else {
            val afterPoint =
                text.substring(text.indexOf('.') + 1, text.length)
            if (afterPoint.isNotEmpty()) {
                strange += "."
                for (i in afterPoint.indices) {
                    strange += "0"
                }
            }
        }
        val formatter = DecimalFormat(strange, unusualSymbols)
        val temp = text.replace("AED ", "")
            .replace(",", "")

        return formatter.format(temp.toBigDecimal())
    }

    fun setTextStyleFormatted(text: String) {
        if (text.isNotEmpty()) {
            var formattedText = getTextFormatted(text)
            formattedText = "AED $formattedText"
            val afterPoint =
                formattedText.substring(formattedText.indexOf('.') + 1, formattedText.length)
            if (afterPoint.toBigDecimal() * BigDecimal(1) == BigDecimal(0)) {
                val spannable: Spannable = SpannableString(formattedText)
                var startIndex = formattedText.indexOf(".")
                if (decimalClicked) {
                    startIndex = formattedText.indexOf(".") + 1
                }
                spannable.setSpan(
                    ForegroundColorSpan(binding.txtInput.currentHintTextColor),
                    startIndex,
                    formattedText.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                binding.txtInput.setText(spannable, TextView.BufferType.SPANNABLE)
            } else {
                binding.txtInput.text = formattedText
            }
        } else
            binding.txtInput.text = ""
    }

}