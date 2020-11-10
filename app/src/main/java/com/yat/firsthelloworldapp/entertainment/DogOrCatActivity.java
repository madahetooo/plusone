package com.yat.firsthelloworldapp.entertainment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

public class DogOrCatActivity extends Fragment  implements View.OnClickListener {


    RadioGroup choicesRadioGroup1, choicesRadioGroup2, choicesRadioGroup3;
    RadioButton radioButton1, radioButton2, radioButton3;
    TextView tvResult;
    View view;
    Button btnGetResult;

    private static final int RB1_ID =2000;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

         view = inflater.inflate(R.layout.activity_dog_or_cat, container, false);

        choicesRadioGroup1 = view.findViewById(R.id.radio_group1);
        choicesRadioGroup2 = view.findViewById(R.id.radio_group2);
        choicesRadioGroup3 = view.findViewById(R.id.radio_group3);
        tvResult = view.findViewById(R.id.tv_result);
        radioButton1 =view.findViewById(R.id.radio_never);
        btnGetResult = view.findViewById(R.id.btn_get_result);
        btnGetResult.setOnClickListener(this);
        radioButton1.setId(RB1_ID);


        return view;

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dog_or_cat);
//
//
//    }


    @Override
    public void onClick(View v) {
        int selectedRadioButton = choicesRadioGroup1.getCheckedRadioButtonId();  // get the radio button which checked

        radioButton1 = view.findViewById(selectedRadioButton);  // pass checked radio button to an object


        int selectedRadioButton2 = choicesRadioGroup2.getCheckedRadioButtonId();

        radioButton2 = view.findViewById(selectedRadioButton2);

        int selectedRadioButton3 = choicesRadioGroup3.getCheckedRadioButtonId();

        radioButton3 = view.findViewById(selectedRadioButton3);


        if (choicesRadioGroup1.getCheckedRadioButtonId() == -1 || choicesRadioGroup2.getCheckedRadioButtonId() == -1 ||
                choicesRadioGroup3.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getContext(), "Please Choose Choice", Toast.LENGTH_SHORT).show();
        } else {
            if (radioButton1.getText().toString().toUpperCase().equals("NEVER") &&
                    radioButton2.getText().toString().toUpperCase().equals("ALL THE TIMES") &&
                    radioButton3.getText().toString().toUpperCase().equals("NO WAY")) {
                tvResult.setText("You Are A Cat Person");
            } else if (radioButton1.getText().toString().toUpperCase().equals("ALWAYS") &&
                    radioButton2.getText().toString().toUpperCase().equals("SOMETIMES") &&
                    radioButton3.getText().toString().toUpperCase().equals("ONCE OR TWICE")) {
                tvResult.setText("You Are A DOG Person");
            } else if (radioButton1.getText().toString().toUpperCase().equals("SOMETIMES") &&
                    radioButton2.getText().toString().toUpperCase().equals("NO") &&
                    radioButton3.getText().toString().toUpperCase().equals("MAYBE")) {
                tvResult.setText("You Are A CAT Person");
            }
        }
    }
}