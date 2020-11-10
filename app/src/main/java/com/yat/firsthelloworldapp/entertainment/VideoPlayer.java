package com.yat.firsthelloworldapp.entertainment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.yat.firsthelloworldapp.R;

public class VideoPlayer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        VideoView youCanVideo = findViewById(R.id.videoView);
        VideoView justinVideo = findViewById(R.id.videoView2);

//        Uri videoUri = Uri.parse("https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_1280_10MG.mp4");


        //Video Number one
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.youcan);
        MediaController mediaController = new MediaController(this);  // initialize mediacontroller
        youCanVideo.setVideoURI(videoUri); //set video URI
        mediaController.setAnchorView(youCanVideo); //set Anchor View on video
        youCanVideo.setMediaController(mediaController); // set Media Controller for the video
        youCanVideo.start();


        // Video Number Two
        Uri videoUri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jutin);
        MediaController mediaController2 = new MediaController(this);
        justinVideo.setVideoURI(videoUri2);
        mediaController2.setAnchorView(justinVideo);
        justinVideo.setMediaController(mediaController2);
        justinVideo.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_music:
                Intent goToMusicActivity = new Intent(getApplicationContext(), MusicActivity.class);
                startActivity(goToMusicActivity);
                break;
            case R.id.item_test:
                Toast.makeText(this, "You Clicked on Test Item", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}