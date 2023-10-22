package com.example.agap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agap.RetrieveResponder.MapPoliceRetrieve;
import com.example.agap.RetrieveResponder.NotifPoliceRetrieve;
import com.example.agap.RetrieveResponder.ReportPoliceRetrieve;

public class PoliceResponder extends AppCompatActivity {


    Button picLocate , notif , report, adminpanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_responder);


        picLocate = findViewById(R.id.mapDisaster);
        notif = findViewById(R.id.call);
        report = findViewById(R.id.report);
        adminpanel = findViewById(R.id.panel);

        picLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoliceResponder.this , MapPoliceRetrieve.class);
                startActivity(intent);
                finish();
            }
        });

        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoliceResponder.this , NotifPoliceRetrieve.class);
                startActivity(intent);
                finish();
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoliceResponder.this , ReportPoliceRetrieve.class);
                startActivity(intent);
                finish();
            }
        });

        adminpanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoliceResponder.this , Camera.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
