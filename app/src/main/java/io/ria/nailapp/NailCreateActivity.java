package io.ria.nailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import io.ria.nailapp.Model.NailModel;
import io.ria.nailapp.Utils.NailDBHelper;

public class NailCreateActivity extends AppCompatActivity {

    private Button mSaveButton;
    private NailDBHelper nailDBHelper;
    private CheckBox mS1;
    private CheckBox mS2;
    private CheckBox mS3;
    private CheckBox mS4;
    private EditText mFullName;
    private EditText mEmail;
    private EditText mPhoneNumber;
    private EditText mTime;
    private RadioButton mRadioam;
    private RadioButton mRadiopm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nailcreate);

        mS1 = findViewById(R.id.s_1);
        mS2 = findViewById(R.id.s_2);
        mS3 = findViewById(R.id.s_3);
        mS4 = findViewById(R.id.s_4);



        nailDBHelper = new NailDBHelper(NailCreateActivity.this);
        mSaveButton = findViewById(R.id.btn_finish);
        mFullName = findViewById(R.id.txt_full_name);
        mEmail = findViewById(R.id.txt_email);
        mPhoneNumber = findViewById((R.id.txt_phone));
        mTime = findViewById(R.id.txt_time);
        mRadioam = findViewById(R.id.radio_am);
        mRadiopm = findViewById((R.id.radio_pm));



        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = calculatePrice(mS1,mS2,mS3,mS4);
                String fullName = mFullName.getText().toString();
                String  email = mEmail.getText().toString();
                String phoneNumber = mPhoneNumber.getText().toString();
                String service = getService(mS1,mS2,mS3,mS4);
                String myTime = getTime(mTime,mRadioam,mRadiopm);

                if (!fullName.equals("")) {
                    NailModel item = new NailModel();
                    item.setFullName(fullName);
                    item.setEmail(email);
                    item.setPhone(phoneNumber);
                    item.setService(service);
                    item.setTask(text);
                    item.setStatus(0);
                    item.setTime(myTime);
                    nailDBHelper.insertTask(item);
                }
                Intent intent = new Intent(NailCreateActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    private String getService(CheckBox mS1, CheckBox mS2, CheckBox mS3, CheckBox mS4) {
        String result = "";
        if(mS1.isChecked()){
            result += "mr  ";
        }
        if(mS2.isChecked()){
            result += "mj  ";
        }
        if(mS3.isChecked()){
            result += "pr  ";
        }
        if(mS4.isChecked()){
            result += "pj  ";
        }
        return result;
    }
    private String calculatePrice(CheckBox mS1, CheckBox mS2, CheckBox mS3, CheckBox mS4){

        double  total = 0.00;
        if(mS1.isChecked()){
            total += 35;
        }
        if(mS2.isChecked()){
            total += 75;
        }
        if(mS3.isChecked()){
            total += 55;
        }
        if(mS4.isChecked()){
            total += 100;
        }
        String result ="$ ";
        result += (Double.toString(total));
        return result;
    }

    private String getTime(EditText mTime, RadioButton mRadioam, RadioButton mRadiopm){

        String result = mTime.getText().toString();

        if (mRadioam.isChecked()){
            result += " am";
        } else {
            result += " pm";
        }
        return  result;
    }
}