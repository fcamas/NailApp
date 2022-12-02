package io.ria.nailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import io.ria.nailapp.DB.DBNailCustomerHelper;
import io.ria.nailapp.Model.NailCustomerModel;
import io.ria.nailapp.Model.ToDoModel;
import io.ria.nailapp.Utils.DataBaseHelper;

public class MainActivity2 extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView mEmail;
    private TextView mPhone;
    private TextView mDate;
    private CheckBox mOptionOne;
    private CheckBox mOptionTwo;
    private CheckBox mOptionThree;
    private CheckBox mOptionFour;
    private Button mFinish;
    private DBNailCustomerHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        mEmail = findViewById(R.id.email);
        mPhone = findViewById(R.id.txt_phone);
        mDate = findViewById(R.id.txt_date);
        mOptionOne = findViewById(R.id.option_1);
        mOptionTwo = findViewById(R.id.option_2);
        mOptionThree = findViewById(R.id.option_3);
        mOptionFour = findViewById(R.id.option_4);
        mFinish = findViewById(R.id.btn_finish);

        boolean isUpdate = false;

        mFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = firstName.getText().toString() + lastName.getText().toString();
                String nEmail = mEmail.getText().toString();
                String nCellPhone = mPhone.getText().toString();
                String nDate = mDate.getText().toString();
                int nO1 = mOptionOne.isChecked() ? 1 : 0;
                int nO2 = mOptionTwo.isChecked() ? 1 : 0;
                int nO3 = mOptionThree.isChecked() ? 1 : 0;
                int nO4 = mOptionFour.isChecked() ? 1 : 0;

                    NailCustomerModel model = new NailCustomerModel();
                    model.setFullName(fullName);
                    model.setEmail(nEmail);
                    model.setCellPhone(nCellPhone);
                    model.setAppointmentDate(nDate);
                    model.setOptionOne(nO1);
                    model.setOptionTwo(nO2);
                    model.setOptionThree(nO3);
                    model.setOptionFour(nO4);
                    dbHelper.insertInCard(model);


            }
        });
    }
}