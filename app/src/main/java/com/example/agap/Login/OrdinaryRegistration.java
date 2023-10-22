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

import com.example.agap.FillUP;
import com.example.agap.R;
import com.example.agap.User.UserActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class OrdinaryRegistration extends AppCompatActivity {

    EditText mEmail, mPass, mName;
    Button btnSignUP, btnSignIN;
    Boolean valid = true;
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary_registration);


        //Get Firebase auth instance
        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();

        mEmail = findViewById(R.id.email);
        mPass = findViewById(R.id.password);
        mName = findViewById(R.id.name);
        btnSignUP = findViewById(R.id.signuprespondertoactivity);
        btnSignIN = findViewById(R.id.signin);



                btnSignUP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        checkField(mName);
                        checkField(mEmail);
                        checkField(mPass);


                        if (valid) {
                            mAuth.createUserWithEmailAndPassword(mEmail.getText().toString(), mPass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(OrdinaryRegistration.this, "Account File Uploaded", Toast.LENGTH_LONG).show();
                                    DocumentReference df = mStore.collection("Users").document(user.getUid());
                                    Map<String, Object> departmentInfo = new HashMap<String, Object>();
                                    departmentInfo.put("FullName", mName.getText().toString());
                                    departmentInfo.put("Email", mEmail.getText().toString());

                                    //check if the user is what part

                                    departmentInfo.put("isUser", "1");

                                    df.set(departmentInfo);
                                    startActivity(new Intent(getApplicationContext(), UserActivity.class));
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(OrdinaryRegistration.this, "Failed to Register an account", Toast.LENGTH_LONG).show();

                                }
                            });

                        }


                    }
                });
                btnSignIN.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), ResponderLogin.class));
                    }
                });


            }


          private boolean checkField(EditText textField) {
              if (textField.getText().toString().isEmpty()) {
                  textField.setError("error");
                  valid = false;
              } else {
                  valid = true;
              }
              return valid;

          }

          @Override
          protected void onResume() {
              super.onResume();
          }
      }
