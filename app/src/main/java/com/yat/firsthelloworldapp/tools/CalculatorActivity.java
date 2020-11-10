package com.yat.firsthelloworldapp.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

public class CalculatorActivity extends Fragment implements View.OnClickListener {

    EditText editText1, editText2;
    Button addition, substraction, multiplication, division;
    TextView tvResult;
    String numberOneValueString, numberTwoValueString;
    double numberOneValueDouble, numberTwoValueDouble, operation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_calculator, container, false);
        editText1 = v.findViewById(R.id.et_number1);
        editText2 = v.findViewById(R.id.et_number2);
        addition = v.findViewById(R.id.btn_add);
        substraction = v.findViewById(R.id.btn_sub);
        multiplication = v.findViewById(R.id.btn_multiplication);
        division = v.findViewById(R.id.btn_division);
        tvResult = v.findViewById(R.id.tv_result);
        addition.setOnClickListener(this);
        substraction.setOnClickListener(this);
        multiplication.setOnClickListener(this);
        division.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                numberOneValueString = editText1.getText().toString().trim();
                numberTwoValueString = editText2.getText().toString().trim();

                if (!numberOneValueString.isEmpty() && !numberTwoValueString.isEmpty()) {
                    numberOneValueDouble = Double.parseDouble(numberOneValueString);

                    //getting number two from the edit text 2
                    numberTwoValueDouble = Double.parseDouble(numberTwoValueString);

                    operation = numberOneValueDouble + numberTwoValueDouble;

                    tvResult.setText("Result is : " + operation);
                } else {
                    Toast.makeText(getContext(), "Please Enter values", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_sub:
                if (!numberOneValueString.isEmpty() && !numberTwoValueString.isEmpty()) {
                    numberOneValueString = editText1.getText().toString().trim();
                    numberOneValueDouble = Double.parseDouble(numberOneValueString);

                    //getting number two from the edit text 2
                    numberTwoValueString = editText2.getText().toString().trim();
                    numberTwoValueDouble = Double.parseDouble(numberTwoValueString);

                    operation = numberOneValueDouble - numberTwoValueDouble;

                    tvResult.setText("Result is : " + operation);
                } else {
                    Toast.makeText(getContext(), "Please Enter values", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_multiplication:
                if (!numberOneValueString.isEmpty() && !numberTwoValueString.isEmpty()) {
                    numberOneValueString = editText1.getText().toString().trim();
                    numberOneValueDouble = Double.parseDouble(numberOneValueString);

                    //getting number two from the edit text 2
                    numberTwoValueString = editText2.getText().toString().trim();
                    numberTwoValueDouble = Double.parseDouble(numberTwoValueString);

                    operation = numberOneValueDouble * numberTwoValueDouble;

                    tvResult.setText("Result is : " + operation);
                } else {
                    Toast.makeText(getContext(), "Please Enter values", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_division:
                if (!numberOneValueString.isEmpty() && !numberTwoValueString.isEmpty()) {
                    numberOneValueString = editText1.getText().toString().trim();
                    numberOneValueDouble = Double.parseDouble(numberOneValueString);

                    //getting number two from the edit text 2
                    numberTwoValueString = editText2.getText().toString().trim();
                    numberTwoValueDouble = Double.parseDouble(numberTwoValueString);

                    operation = numberOneValueDouble / numberTwoValueDouble;

                    tvResult.setText("Result is : " + operation);
                } else {
                    Toast.makeText(getContext(), "Please Enter values", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}