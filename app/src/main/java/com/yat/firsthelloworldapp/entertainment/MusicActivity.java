package com.yat.firsthelloworldapp.entertainment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yat.firsthelloworldapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class MusicActivity extends Fragment implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    SeekBar seekBarJustinMusic;  //declare object for view
    MediaPlayer songMediaPlayer;  // initialize object from Media player class
    int seekBarPosition;   // declare variable for seekBar position
    ImageView ivPlay, ivPause, ivStop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_music, container, false);
        seekBarJustinMusic = v.findViewById(R.id.seekBarJustin);  // find view
        ivPlay = v.findViewById(R.id.iv_play);
        ivPause = v.findViewById(R.id.iv_pause);
        ivStop = v.findViewById(R.id.iv_stop);
        ivStop.setOnClickListener(this);
        ivPlay.setOnClickListener(this);
        ivPause.setOnClickListener(this);


        seekBarJustinMusic.setOnSeekBarChangeListener(this);  //set On click listener


        //Set Timer task and progress for the seekbar
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (songMediaPlayer != null)
                    seekBarJustinMusic.setProgress(songMediaPlayer.getCurrentPosition());
            }
        }, 0, 500);


        return v;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean user) {
        if (user) {
            songMediaPlayer.seekTo(progress);

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_play:
                if (songMediaPlayer == null) {
                    songMediaPlayer = MediaPlayer.create(getContext(), R.raw.baby);  // call song from raw file
                    seekBarJustinMusic.setMax(songMediaPlayer.getDuration());  // set Max for the seekBar as Song duration
                    songMediaPlayer.start(); // call start method
                } else if (!songMediaPlayer.isPlaying()) {
                    songMediaPlayer.seekTo(seekBarPosition);
                    songMediaPlayer.start();
                }
                break;
            case R.id.iv_pause:
                songMediaPlayer.pause();  // call pause method
                seekBarPosition = songMediaPlayer.getCurrentPosition();  // set seekBar position where it paused
                break;
            case R.id.iv_stop:
                if (songMediaPlayer != null) { // check if song is playing
                    seekBarJustinMusic.setProgress(0);  // reset seekBar position
                    songMediaPlayer.stop();  //call stop method
                    songMediaPlayer = null; // let song equal null
                }
                break;
        }
    }
}