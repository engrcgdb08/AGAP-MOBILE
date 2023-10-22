package com.example.agap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotificationDisaster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_disaster);

        TextView textView = findViewById(R.id.notificationDisaster);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);
    }
}
