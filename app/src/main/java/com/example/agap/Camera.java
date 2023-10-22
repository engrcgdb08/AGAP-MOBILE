package com.example.agap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Camera extends YouTubeBaseActivity {

    private static final String TAG = "Camera";

    YouTubePlayerView youTubePlayerView;
    Button btnplay;
    YouTubePlayer.OnInitializedListener mOnintializedlistener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Log.d(TAG, "onClick: Starting ...");

        youTubePlayerView = findViewById(R.id.youtubePlayer);
        btnplay = findViewById(R.id.btnPlay);

        mOnintializedlistener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick: Done Initializing.");
                youTubePlayer.loadVideo("RGtZjnFsN0c");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick: Failed to Initialize");
            }
        };
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Initializing AGAP Beta Cam");
                youTubePlayerView.initialize(YoutubeApi.getYtKey(), mOnintializedlistener);
            }
        });

    }
}