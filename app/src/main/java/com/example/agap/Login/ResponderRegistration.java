package com.example.agap.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agap.FillUP;
import com.example.agap.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ResponderRegistration extends AppCompatActivity {

    EditText mEmail, mPass, mAddress, mName, mNumber, mDepartment;
    Button btnSignUP, btnSignIN;
    Boolean valid = true;
    FirebaseAuth mAuth;
    FirebaseFirestore mStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_registration);

        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();

        mEmail = findViewById(R.id.emailResponder);
        mPass = findViewById(R.id.passResponder);
        mAddress = findViewById(R.id.address);
        mName = findViewById(R.id.name);
        mDepartment = findViewById(R.id.respondertype);
        mNumber = findViewById(R.id.cpnumber);
        btnSignUP = findViewById(R.id.btnSignUp);
        btnSignIN = findViewById(R.id.btnSignIn);


        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkField(mAddress);
                checkField(mName);
                checkField(mEmail);
                checkField(mPass);
                checkField(mNumber);
                checkField(mDepartment);

                if (valid) {
                    mAuth.createUserWithEmailAndPassword(mEmail.getText().toString(), mPass.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(ResponderRegistration.this, "Account File Uploaded", Toast.LENGTH_LONG).show();
                            DocumentReference df = mStore.collection("Users").document(user.getUid());
                            Map<String, Object> departmentInfo = new HashMap<String, Object>();
                            departmentInfo.put("FullName", mName.getText().toString());
                            departmentInfo.put("Address", mAddress.getText().toString());
                            departmentInfo.put("Email", mEmail.getText().toString());
                            departmentInfo.put("PhoneNumber", mNumber.getText().toString());
                            departmentInfo.put("Department", mDepartment.getText().toString());

                            //check if the user is what part

                            departmentInfo.put("isUser", "1");

                            df.set(departmentInfo);
                            startActivity(new Intent(getApplicationContext(), FillUP.class));
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ResponderRegistration.this, "Failed to Register an account", Toast.LENGTH_LONG).show();

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
