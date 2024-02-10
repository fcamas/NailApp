package com.example.onschedule

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var mSaveButton: Button
    private lateinit var manicureFullSet: CheckBox
    private lateinit var pedicureFullSet: CheckBox
    private lateinit var manicureJelly: CheckBox
    private lateinit var pedicureJelly: CheckBox
    private lateinit var mFullName: EditText
    private lateinit var mEmail: EditText
    private lateinit var mPhoneNumber: EditText
    private lateinit var mTime: EditText
    private lateinit var mRadioam: RadioButton
    private lateinit var mRadiopm: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
            manicureFullSet = findViewById(R.id.manicure_fullset)
            pedicureFullSet = findViewById(R.id.pedicureFullset)
            manicureJelly = findViewById(R.id.manicure_jelly)
            pedicureJelly = findViewById(R.id.pedicure_jelly)
            mSaveButton = findViewById(R.id.btn_finish)
            mFullName = findViewById(R.id.cell_fullname)
            mEmail = findViewById(R.id.cell_email)
            mPhoneNumber = findViewById(R.id.editPhoneNumber)
            mTime = findViewById(R.id.txt_time)
            mRadioam = findViewById(R.id.radio_am)
            mRadiopm = findViewById(R.id.radio_pm)
    }

    private fun getService(mS1: CheckBox, mS2: CheckBox, mS3: CheckBox, mS4: CheckBox): String {
        var result = ""
        if (mS1.isChecked) {
            result += "mr  "
        }
        if (mS2.isChecked) {
            result += "mj  "
        }
        if (mS3.isChecked) {
            result += "pr  "
        }
        if (mS4.isChecked) {
            result += "pj  "
        }
        return result
    }
    private fun calculatePrice(mS1: CheckBox, mS2: CheckBox, mS3: CheckBox, mS4: CheckBox): String {
        var total = 0.0
        if (mS1.isChecked) {
            total += 35
        }
        if (mS2.isChecked) {
            total += 75
        }
        if (mS3.isChecked) {
            total += 55
        }
        if (mS4.isChecked) {
            total += 100
        }
        val result = "$$total"
        return result
    }

    private fun getTime(mTime: EditText, mRadioam: RadioButton, mRadiopm: RadioButton): String {
        var result = mTime.text.toString()

        result += if (mRadioam.isChecked) {
            " am"
        } else {
            " pm"
        }
        return result
    }
}