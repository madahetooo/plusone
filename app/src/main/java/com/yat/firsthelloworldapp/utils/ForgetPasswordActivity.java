package com.yat.firsthelloworldapp.utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yat.firsthelloworldapp.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    Button btn_showCode;
    EditText recoveryMailEdittext;
    String recoveryMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_activity);


        btn_showCode = findViewById(R.id.btn_forgetPassword);
        recoveryMailEdittext = findViewById(R.id.et_recoveryMail);

        btn_showCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                recoveryMail = recoveryMailEdittext.getText().toString().trim();

                if (!recoveryMail.equals("")){
                    Toast.makeText(ForgetPasswordActivity.this, "We sent the code to : " + recoveryMail, Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(ForgetPasswordActivity.this, "Please Enter your recovery mail", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}