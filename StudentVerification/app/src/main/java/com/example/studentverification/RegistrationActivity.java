package com.example.studentverification;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    ImageView imageGallery;
    ImageView addImageBtn;
    EditText firstnameField;
    EditText lastnameField;
    EditText emailField;
    EditText semesterField;
    Button registerBtn;

    private ActivityResultLauncher<Intent> imagePickerLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri selectedImageUri = result.getData().getData();
                    imageGallery.setImageURI(selectedImageUri);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        imageGallery = findViewById(R.id.imageGallery);
        addImageBtn = findViewById(R.id.addBtn);
        firstnameField = findViewById(R.id.firstnameTxt);
        lastnameField = findViewById(R.id.lastnameTxt);
        emailField = findViewById(R.id.emailTxt);
        semesterField = findViewById(R.id.semesterTxt);
        registerBtn = findViewById(R.id.registerBtn);

        addImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                imagePickerLauncher.launch(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = firstnameField.getText().toString();
                String lastname = lastnameField.getText().toString();
                String email = emailField.getText().toString();
                String semester = semesterField.getText().toString();

                navigateToVerificationPage(firstname, lastname, email, semester);
            }
        });
    }

    void navigateToVerificationPage(String firstname, String lastname, String email, String semester) {
        Intent intent = new Intent(RegistrationActivity.this, VerificationActivity.class);
        intent.putExtra("firstname", firstname);
        intent.putExtra("lastname", lastname);
        intent.putExtra("email", email);
        intent.putExtra("semester", semester);

        toastLauncher.launch(intent);
    }

    private ActivityResultLauncher<Intent> toastLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Toast sucessToast = Toast.makeText(RegistrationActivity.this,"Registration successful!", Toast.LENGTH_SHORT);
                    sucessToast.show();
                }
            }
    );
}