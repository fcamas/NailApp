package com.example.onschedule

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var mSaveButton: Button
    private lateinit var mS1: CheckBox
    private lateinit var mS2: CheckBox
    private lateinit var mS3: CheckBox
    private lateinit var mS4: CheckBox
    private lateinit var mFullName: EditText
    private lateinit var mEmail: EditText
    private lateinit var mPhoneNumber: EditText
    private lateinit var mTime: EditText
    private lateinit var mRadioam: RadioButton
    private lateinit var mRadiopm: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}