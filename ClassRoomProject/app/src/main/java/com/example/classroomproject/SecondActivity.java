package com.example.classroomproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView emailText;
    Button proceedBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String email = getIntent().getStringExtra("email");

        emailText = findViewById(R.id.emailText);
        emailText.setText("Email: " + email);
        proceedBtn = findViewById(R.id.proceedBtn);

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToThirdActivity(email);
            }
        });
    }

    void navigateToThirdActivity(String email) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
}