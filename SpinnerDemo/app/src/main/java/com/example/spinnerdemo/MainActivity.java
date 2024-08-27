package com.example.spinnerdemo;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView firstnameField;
    TextView lastnameField;
    RadioGroup genderRadio;
    String selectedGender;
    TextView genderRadioError;
    Spinner statusSpinner;
    String[] spinnerItems = {"Married", "Unmarried", "Divorced"};

    String selectedStatus;
    TextView statusSpinnerError;
    CheckBox termsCheckBox;
    TextView termsCheckBoxError;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstnameField = findViewById(R.id.firstnameTxt);
        lastnameField = findViewById(R.id.lastnameTxt);
        genderRadioError = findViewById(R.id.genderRadioError);
        statusSpinnerError = findViewById(R.id.statusSpinnerError);
        termsCheckBoxError = findViewById(R.id.termsCheckBoxError);

        genderRadio = findViewById(R.id.genderRadio);
        genderRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = genderRadio.findViewById(checkedId);
            }
        });

        statusSpinner = findViewById(R.id.statusSpinner);
        statusSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, spinnerItems
        );
        statusSpinner.setAdapter(arrayAdapter);

        termsCheckBox = findViewById(R.id.termsCheckbox);

        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedStatus = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void validateInput() {
        String firstname = firstnameField.getText().toString();
        if (firstname == null || firstname.isEmpty()) firstnameField.setError("Invalid input.");
        String lastname = lastnameField.getText().toString();
        if (lastname == null || lastname.isEmpty()) firstnameField.setError("Invalid input.");

        int selectedGenderId = genderRadio.getCheckedRadioButtonId();
        if (genderRadio.getCheckedRadioButtonId() == -1) {
            genderRadioError.setVisibility(View.VISIBLE);
        } else {
            RadioButton radioButton = genderRadio.findViewById(selectedGenderId);
            selectedGender = radioButton.getText().toString();
        }

        if (selectedStatus.isEmpty()) {
            statusSpinnerError.setVisibility(View.VISIBLE);
        }

        if(!termsCheckBox.isChecked()) {
            termsCheckBoxError.setVisibility(View.VISIBLE);
        }
    }

}