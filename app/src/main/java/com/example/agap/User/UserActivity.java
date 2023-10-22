package com.example.agap.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agap.Call.CallDisaster;
import com.example.agap.Call.CallFire;
import com.example.agap.Call.CallHospital;
import com.example.agap.Call.CallPolice;
import com.example.agap.Login.ResponderLogin;
import com.example.agap.MapsActivity.MapsActivityDisaster;
import com.example.agap.MapsActivity.MapsActivityPolice;
import com.example.agap.R;
import com.example.agap.UserReport;
import com.example.agap.UserReportPolice;

public class UserActivity extends AppCompatActivity {

    Button mPolice, mHospital , mDisaster , mFire, logout , mLoc, mReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mLoc = findViewById(R.id.piclocate);

        mPolice = findViewById(R.id.btnPolice);
        mHospital = findViewById(R.id.btnHospital);
        mDisaster = findViewById(R.id.btnDisaster);
        mFire = findViewById(R.id.btnFire);
        logout = findViewById(R.id.logout);
        mReport = findViewById(R.id.report);


        mLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, MapsActivityPolice.class);
                startActivity(intent);
                finish();
            }
        });


      mReport.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent (UserActivity.this , UserReport.class);
              startActivity(intent);
              finish();
          }
      });

        mPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (UserActivity.this , CallPolice.class);
                startActivity(intent);
                finish();
            }
        });


        mHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (UserActivity.this , CallHospital.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        mDisaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (UserActivity.this , CallDisaster.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        mFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (UserActivity.this , CallFire.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResponderLogin.class));
                finish();
            }
        });


        // location



    }
}
