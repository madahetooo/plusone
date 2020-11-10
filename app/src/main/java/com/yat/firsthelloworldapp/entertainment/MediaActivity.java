package com.yat.firsthelloworldapp.entertainment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yat.firsthelloworldapp.R;

public class MediaActivity extends Fragment implements View.OnClickListener {
    View view;
    Button btnGoToExoPlayer, btnGoToMediaBuiltIn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_media, container, false);
        btnGoToExoPlayer = view.findViewById(R.id.btn_ExoPlayer);
        btnGoToMediaBuiltIn = view.findViewById(R.id.btn_MediaBuiltIn);
        btnGoToExoPlayer.setOnClickListener(this);
        btnGoToMediaBuiltIn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_ExoPlayer:
                Intent intent = new Intent(getContext(),ExoPlayerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_MediaBuiltIn:
                Intent intent2 = new Intent(getContext(),VideoPlayer.class);
                startActivity(intent2);
                break;
        }

    }
}