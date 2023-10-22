package com.example.agap.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agap.R;
import com.example.agap.User.UserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class OrdinaryLogin extends AppCompatActivity {

    Animation botAnim, leftAnim;

    ImageView image;
    TextView textanim;
    EditText mEmail, mPass;
    Button mSignin, mSignup;
    FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary_login);

        botAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_navigation);

        image = findViewById(R.id.agaplogo);
        textanim = findViewById(R.id.emergencyapp);
        image.setAnimation(leftAnim);
        textanim.setAnimation(botAnim);

        mEmail = (EditText) findViewById(R.id.email);
        mPass = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mSignin = (Button) findViewById(R.id.respondersignin);


        mAuth = FirebaseAuth.getInstance();

        mEmail = (EditText) findViewById(R.id.email);
        mPass = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdinaryLogin.this, OrdinaryRegistration.class);
                startActivity(intent);
                finish();

            }
        });
        mAuth = FirebaseAuth.getInstance();
        //Get Firebase auth instance
        mSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password = mPass.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(OrdinaryLogin.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(OrdinaryLogin.this, UserActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                if (!task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Log in Failed!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });

    }

        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
        }
    }
