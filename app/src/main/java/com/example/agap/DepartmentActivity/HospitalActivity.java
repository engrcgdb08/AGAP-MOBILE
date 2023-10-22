package com.example.agap.DepartmentActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.agap.Call.CallHospital;
import com.example.agap.MapsActivity.MapsActivityHospital;
import com.example.agap.R;
import com.example.agap.UserReportHospital;

public class HospitalActivity extends AppCompatActivity {

    Button mPicLocate , mCall , mReport , mFire , mPolice , mDisaster, mHospital;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        mPicLocate = findViewById(R.id.mapDisaster);
        mCall= findViewById(R.id.notificationHospital);
        mReport = findViewById(R.id.report);



        mPolice = findViewById(R.id.police);
        mFire = findViewById(R.id.fire);
        mDisaster = findViewById(R.id.disaster);
        mHospital = findViewById(R.id.hospital);


        mPicLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HospitalActivity.this , MapsActivityHospital.class);
                startActivity(intent);
                finish();
            }
        });

        mReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HospitalActivity.this , UserReportHospital.class);
                startActivity(intent);
                finish();
            }
        });


        mPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HospitalActivity.this, OrdinaryEmergency.class);
                startActivity(intent);

            }
        });

        mDisaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HospitalActivity.this, DisasterActivity.class);
                startActivity(intent);

            }
        });


        mFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HospitalActivity.this, FireActivity.class);
                startActivity(intent);

            }
        });



mCall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent (HospitalActivity.this, CallHospital.class);
        startActivity(intent);
    }
});


    }
}
