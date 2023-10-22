package com.example.agap.DepartmentActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agap.MapsActivity.MapsActivityDisaster;
import com.example.agap.MapsActivity.MapsActivityFire;
import com.example.agap.R;
import com.example.agap.UserReport;
import com.example.agap.UserReportFire;

public class FireActivity extends AppCompatActivity {

    Button mPicLocate , mCall , mReport , mFire , mPolice , mDisaster, mHospital;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);


        mPicLocate = findViewById(R.id.mapDisaster);
        mCall= findViewById(R.id.call);
        mReport = findViewById(R.id.report);

        mPolice = findViewById(R.id.police);
        mFire = findViewById(R.id.fire);
        mDisaster = findViewById(R.id.disaster);
        mHospital = findViewById(R.id.hospital);


        mPicLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FireActivity.this , MapsActivityFire.class);
                startActivity(intent);
                finish();
            }
        });

        mReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FireActivity.this , UserReportFire.class);
                startActivity(intent);
                finish();
            }
        });



        mPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FireActivity.this, OrdinaryEmergency.class);
                startActivity(intent);

            }
        });

        mDisaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FireActivity.this, DisasterActivity.class);
                startActivity(intent);

            }
        });


        mHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FireActivity.this, HospitalActivity.class);
                startActivity(intent);

            }
        });






    }
}
