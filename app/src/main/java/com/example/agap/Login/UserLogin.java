package com.example.agap.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.agap.R;

public class UserLogin extends AppCompatActivity {

    Animation topAnim, bottomAnim, leftAnim;
    ImageView image, login_icon;
    TextView logo, slogan;
    Button ResButton, ULogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        // Initialize email firebase auth


        //transition


        ResButton = (Button) findViewById(R.id.responder_login);
        ULogin = (Button) findViewById(R.id.user_login);

        ResButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this, ResponderRegistration.class);
                startActivity(intent);
                finish();


            }
        });

        ULogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserLogin.this, OrdinaryRegistration.class);
                startActivity(intent);
                finish();
            }
        });
    }
}