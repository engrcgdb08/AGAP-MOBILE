package com.example.agap.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agap.DisasterResponder;
import com.example.agap.FireResponder;
import com.example.agap.HospitalResponder;
import com.example.agap.PoliceResponder;
import com.example.agap.R;

public class ResponderActivity extends AppCompatActivity {


    Button police,hospital,disaster,fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder);
        police = findViewById(R.id.police);
        disaster = findViewById(R.id.disaster);
        fire = findViewById(R.id.fire);
        hospital = findViewById(R.id.hospital);


        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResponderActivity.this , PoliceResponder.class);
                startActivity(intent);
                finish();
            }
        });

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResponderActivity.this , HospitalResponder.class);
                startActivity(intent);
                finish();
            }
        });

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResponderActivity.this , FireResponder.class);
                startActivity(intent);
                finish();
            }
        });

       disaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResponderActivity.this , DisasterResponder.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
