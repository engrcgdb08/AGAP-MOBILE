package com.example.agap.DepartmentActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agap.MapsActivity.MapsActivityDisaster;
import com.example.agap.MapsActivity.MapsActivityPolice;
import com.example.agap.R;
import com.example.agap.UserReport;
import com.example.agap.UserReportPolice;

public class OrdinaryEmergency extends AppCompatActivity {

    Button mPicLocate , mCall , mReport , mFire , mDisaster, mHospital;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary_emergency);


        mPicLocate = findViewById(R.id.mapDisaster);
        mCall= findViewById(R.id.call);
        mReport = findViewById(R.id.report);

        mPicLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdinaryEmergency.this , MapsActivityPolice.class);
                startActivity(intent);
                finish();
            }
        });

        mReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdinaryEmergency.this , UserReportPolice.class);
                startActivity(intent);
                finish();
            }
        });

        mFire = findViewById(R.id.fire);
        mDisaster = findViewById(R.id.disaster);
        mHospital = findViewById(R.id.hospital);

        mFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (OrdinaryEmergency.this, FireActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mDisaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (OrdinaryEmergency.this, DisasterActivity.class);
                startActivity(intent);
                finish();
            }
        });


        mHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (OrdinaryEmergency.this, HospitalActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
}
