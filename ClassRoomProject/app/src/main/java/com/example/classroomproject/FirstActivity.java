package com.example.classroomproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends AppCompatActivity {

    EditText emailField;
    EditText passwordField;
    Button LoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        emailField = findViewById(R.id.emailField);
        passwordField = findViewById(R.id.passwordField);
        LoginBtn = findViewById(R.id.loginBtn);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                navigateToSecondActivity(email);
            }
        });
    }

    void navigateToSecondActivity(String email) {
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}