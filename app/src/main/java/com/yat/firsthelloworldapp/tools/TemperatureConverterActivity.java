package com.yat.firsthelloworldapp.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

public class TemperatureConverterActivity extends Fragment implements View.OnClickListener {

    EditText etFahrenheit, etCelsius;
    Button btnConvert, btnReset;
    String etFahrenheitString, etCelsiusString;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_temperature_converter, container, false);


        etFahrenheit = v.findViewById(R.id.et_Fahrenheit);
        etCelsius = v.findViewById(R.id.et_Celsius);

        btnConvert = v.findViewById(R.id.btn_convert);
        btnReset = v.findViewById(R.id.btn_reset);
        btnConvert.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_convert:


                etFahrenheitString = etFahrenheit.getText().toString().trim();
                etCelsiusString = etCelsius.getText().toString().trim();


                if (!etFahrenheitString.isEmpty() && etCelsiusString.isEmpty()) {

                    double convertedValue = Double.parseDouble(etFahrenheitString);
                    String result = String.valueOf((convertedValue - 32) / 1.8);

                    etCelsius.setText(result);
                } else if (etFahrenheitString.isEmpty() && !etCelsiusString.isEmpty()) {
                    double convertedValue = Double.parseDouble(etCelsiusString);
                    String result = String.valueOf(convertedValue * 1.8 + 32);
                    etFahrenheit.setText(result);
                }
                else {
                    Toast.makeText(getContext(), "Please Enter Values", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_reset:

                etFahrenheitString = etFahrenheit.getText().toString().trim();
                etCelsiusString = etCelsius.getText().toString().trim();

                if (etFahrenheitString.isEmpty() && etCelsiusString.isEmpty()){
                    Toast.makeText(getContext(), "There is no value to reset", Toast.LENGTH_SHORT).show();
                }
                else {
                    etFahrenheit.setText("");
                    etCelsius.setText("");
                }


                break;
        }

    }
}