package com.yat.firsthelloworldapp.entertainment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResaurantActivity extends Fragment implements View.OnClickListener {


    int invoice = 0;
    CheckBox chkTea;
    CheckBox chkPepsi;
    CheckBox chkCoffe;
    CheckBox chkLemon;
    CheckBox chkPizza;
    CheckBox chkBurger;
    CheckBox chkChicken;
    CheckBox chkVegetables;
    Button btnOrderNow;
    TextView tvYourOrder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_resaurant, container, false);

        ButterKnife.bind(getActivity());
        chkTea = v.findViewById(R.id.chk_tea);
        chkPepsi = v.findViewById(R.id.chk_pepsi);
        chkCoffe = v.findViewById(R.id.chk_coffe);
        chkLemon = v.findViewById(R.id.chk_Lemon);
        chkPizza = v.findViewById(R.id.chk_pizza);
        chkBurger = v.findViewById(R.id.chk_burger);
        chkChicken = v.findViewById(R.id.chk_chicken);
        chkVegetables = v.findViewById(R.id.chk_vegetables);
        tvYourOrder = v.findViewById(R.id.tv_yourOrder);

        btnOrderNow = v.findViewById(R.id.btn_orderNow);
        btnOrderNow.setOnClickListener(this);


        return v;
    }


    @Override
    public void onClick(View view) {

        StringBuilder totalOrder = new StringBuilder();


        if (chkTea.isChecked()) {
            invoice += 5;
            totalOrder.append(chkTea.getText().toString() + ", ");

        }
        if (chkPepsi.isChecked()) {
            invoice += 10;
            totalOrder.append(chkPepsi.getText().toString() + ", ");

        }
        if (chkCoffe.isChecked()) {
            invoice += 7;
            totalOrder.append(chkCoffe.getText().toString() + ", ");


        }
        if (chkLemon.isChecked()) {
            invoice += 15;
            totalOrder.append(chkLemon.getText().toString() + ", ");


        }
        if (chkPizza.isChecked()) {
            invoice += 70;
            totalOrder.append(chkPizza.getText().toString() + ", ");


        }
        if (chkBurger.isChecked()) {
            invoice += 50;
            totalOrder.append(chkBurger.getText().toString() + ", ");


        }
        if (chkChicken.isChecked()) {
            invoice += 40;
            totalOrder.append(chkChicken.getText().toString() + ", ");


        }
        if (chkVegetables.isChecked()) {
            invoice += 30;
            totalOrder.append(chkVegetables.getText().toString() + ", ");

        }

        tvYourOrder.setText("Your order is : " + totalOrder + " and Your invoice is : " + invoice + "$");
        invoice = 0;

    }
}