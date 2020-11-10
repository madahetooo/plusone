package com.yat.firsthelloworldapp.entertainment;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.yat.firsthelloworldapp.R;

public class ExoPlayerActivity extends AppCompatActivity {


    PlayerView exoPlayerView;
    SimpleExoPlayer simpleExoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);

        exoPlayerView = findViewById(R.id.exoPlayer);
        simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();
        exoPlayerView.setPlayer(simpleExoPlayer);
        Uri uri = RawResourceDataSource.buildRawResourceUri(R.raw.youcan);
        MediaSource mediaSource = buildMediaSource(uri);
        simpleExoPlayer.prepare(mediaSource, false, false);
        simpleExoPlayer.play();
    }
    private MediaSource buildMediaSource(Uri uri) {
        DataSource.Factory dataSourceFactory =
                new DefaultDataSourceFactory(this, "exoplayer-codelab");
        return new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri);
    }

    @Override
    protected void onStop() {

        simpleExoPlayer.stop();
        finish();
        super.onStop();
    }
}