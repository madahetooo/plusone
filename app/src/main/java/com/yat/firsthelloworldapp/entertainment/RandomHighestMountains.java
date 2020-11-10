package com.yat.firsthelloworldapp.entertainment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

import java.util.Random;

public class RandomHighestMountains extends Fragment implements View.OnClickListener {

    Button btnShuffle;
    TextView tvRandomHighestMountains;
    int randomIndex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_random_highest_mountains, container, false);
        btnShuffle = v.findViewById(R.id.btn_shuffle);
        btnShuffle.setOnClickListener(this);
        tvRandomHighestMountains = v.findViewById(R.id.tv_randomMountains);


        return v;
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_shuffle:
                final String mountains[] = {"Everest Mountain", "Alps Mountain", "Colorado Mountains",
                        "Tarek Mountain", "El Mo2atamm Mountain", "Bab El mandap Mountain", "Mousa Mountain",
                        "Saint Catrine Mountain", "Sinia Mountain"};

                Random randomMountains = new Random();  // create object

                randomIndex = randomMountains.nextInt(mountains.length); // shuffle array using index

                tvRandomHighestMountains.setText(mountains[randomIndex]); //print mountains from the array
                break;
        }

    }
}