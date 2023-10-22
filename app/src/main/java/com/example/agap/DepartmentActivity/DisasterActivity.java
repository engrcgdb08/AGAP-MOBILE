package com.example.agap.DepartmentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agap.MapsActivity.MapsActivityDisaster;
import com.example.agap.NotificationDisaster;
import com.example.agap.R;
import com.example.agap.UserReport;

public class DisasterActivity extends AppCompatActivity {

    Button mPicLocate , mCall , mReport , mFire , mPolice, mHospital;
    Button notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster);


        notification = findViewById(R.id.notification);
        mPicLocate = findViewById(R.id.mapDisaster);
        mCall= findViewById(R.id.call);
        mReport = findViewById(R.id.report);

        mPolice = findViewById(R.id.police);
        mFire = findViewById(R.id.fire);
        mHospital = findViewById(R.id.hospital);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "I need help , please assist me.";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(DisasterActivity.this

                )
                        .setSmallIcon(R.drawable.messageicon)
                        .setContentTitle("New Notification")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent = new Intent(DisasterActivity.this , NotificationDisaster.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);

                PendingIntent pendingIntent = PendingIntent.getActivity(DisasterActivity.this
                ,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(0,builder.build());
            }
        });

        mPicLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisasterActivity.this , MapsActivityDisaster.class);
                startActivity(intent);
                finish();
            }
        });

        mReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DisasterActivity.this , UserReport.class);
                startActivity(intent);
                finish();
            }
        });


        mPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DisasterActivity.this, OrdinaryEmergency.class);
                startActivity(intent);
                finish();

            }
        });

        mFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DisasterActivity.this, FireActivity.class);
                startActivity(intent);
                finish();

            }
        });


        mHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (DisasterActivity.this, HospitalActivity.class);
                startActivity(intent);
                finish();

            }
        });



    }
}
