package com.example.agap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.agap.DepartmentActivity.FireActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class UserReportFire extends AppCompatActivity {

    Button btnbrowse, btnupload;
    EditText name, address, complaint;
    ImageView imgview;
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    int Image_Request_Code = 7;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_report_fire);
        storageReference = FirebaseStorage.getInstance().getReference("FireReport");
        databaseReference = FirebaseDatabase.getInstance().getReference("FireReport");
        btnbrowse = findViewById(R.id.btnbrowse);
        btnupload = findViewById(R.id.btnSignIn);

        imgview = findViewById(R.id.image_view);
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        complaint = findViewById(R.id.complaint);

        progressDialog = new ProgressDialog(UserReportFire.this);// context name as per your project name


        btnbrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), Image_Request_Code);

            }
        });
        btnupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                UploadImage();

            }

            private void UploadImage() {

                if (FilePathUri != null) {

                    progressDialog.setTitle("Image is Uploading...");
                    progressDialog.show();
                    StorageReference storageReference2 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(FilePathUri));
                    storageReference2.putFile(FilePathUri)
                            .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                    String TempImageName = name.getText().toString().trim();
                                    String TempAddress = address.getText().toString().trim();
                                    String TempComplaint = complaint.getText().toString().trim();


                                    progressDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();
                                    @SuppressWarnings("VisibleForTests")
                                    uploadinformation imageUploadInfo = new uploadinformation(TempImageName, TempAddress, TempComplaint, taskSnapshot.getUploadSessionUri().toString());
                                    String ImageUploadId = databaseReference.push().getKey();
                                    databaseReference.child(ImageUploadId).setValue(imageUploadInfo);

                                    Intent intent = new Intent(UserReportFire.this, FireActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                } else {

                    Toast.makeText(UserReportFire.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

                }

            }

            private String GetFileExtension(Uri filePathUri) {


                ContentResolver contentResolver = getContentResolver();
                MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
                return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(filePathUri));

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Image_Request_Code && resultCode == RESULT_OK && data != null && data.getData() != null) {

            FilePathUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), FilePathUri);
                imgview.setImageBitmap(bitmap);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}