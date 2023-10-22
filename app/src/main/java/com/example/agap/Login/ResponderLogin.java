package com.example.agap.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agap.DisasterResponder;
import com.example.agap.FireResponder;
import com.example.agap.HospitalResponder;
import com.example.agap.PoliceResponder;
import com.example.agap.R;
import com.example.agap.User.UserActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ResponderLogin extends AppCompatActivity {

    EditText mEmail, mPass;
    Button loginResponder, mFill;
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;


    Boolean valid = true;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_login);


        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();
        mEmail = findViewById(R.id.emailResponder);
        mPass = findViewById(R.id.password);
        loginResponder = findViewById(R.id.respondersignin);
        mFill = findViewById(R.id.fillform);

        mFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResponderLogin.this , ResponderRegistration.class);
                startActivity(intent);
                finish();
            }
        });




        loginResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkField(mEmail);
                checkField(mPass);

                if (valid) {

                    mAuth.signInWithEmailAndPassword(mEmail.getText().toString(), mPass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            checkDepartment(authResult.getUser().getUid());


                            Toast.makeText(ResponderLogin.this, "Logged in Successfully", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), UserActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(ResponderLogin.this, "Log in Failed", Toast.LENGTH_LONG).show();
                        }
                    });
                    //
                }

            }
        });

    }

    private void checkDepartment(String uid) {

        DocumentReference df = mStore.collection("Users").document(uid);
        //extract data from document
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Log.d("TAG", "onSuccess:" + documentSnapshot.getData());
                //identify the type of user

                if (documentSnapshot.getString("isFireResponder") != null) {
                    //user is FireResponder
                    startActivity(new Intent(getApplicationContext(), FireResponder.class));
                }
                if (documentSnapshot.getString("isPoliceResponder") != null) {

                    //user is PoliceResponder
                    startActivity(new Intent(getApplicationContext(), PoliceResponder.class));
                }
                if (documentSnapshot.getString("isDisasterResponder") != null) {

                    //user is DisasterResponder
                    startActivity(new Intent(getApplicationContext(), DisasterResponder.class));
                }
                if (documentSnapshot.getString("isHospitalResponder") != null) {

                    startActivity(new Intent(getApplicationContext(), HospitalResponder.class));
                    //user is HospitalResponder
                }
                if (documentSnapshot.getString("isUser") != null) {

                    startActivity(new Intent(getApplicationContext(), UserActivity.class));
                    finish();
                    //user is HospitalResponder
                }

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