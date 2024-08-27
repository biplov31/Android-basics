package com.example.studentverification;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    TextView fullnameTxt;
    TextView emailTxt;
    TextView semesterTxt;

    Button okayBtn;
    Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        String firstname = getIntent().getStringExtra("firstname");
        String lastname = getIntent().getStringExtra("lastname");
        String email = getIntent().getStringExtra("email");
        String semester = getIntent().getStringExtra("semester");

//        fullnameTxt = findViewById(R.id.fullnameTxt);
//        fullnameTxt.setText(firstname + " " + lastname);
//        emailTxt = findViewById(R.id.emailValue);
//        emailTxt.setText(email);
//        semesterTxt.findViewById(R.id.semesterValue);
//        semesterTxt.setText("Semester: " + semester);

        fullnameTxt = findViewById(R.id.fullnameTxt);
        fullnameTxt.setText(firstname + " " + lastname);

        emailTxt = findViewById(R.id.emailValue);
        emailTxt.setText(email);

        semesterTxt = findViewById(R.id.semesterValue);
        semesterTxt.setText("Semester: " + semester);

        okayBtn = findViewById(R.id.okayBtn);

        okayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}