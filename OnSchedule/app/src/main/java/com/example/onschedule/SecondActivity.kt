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
}