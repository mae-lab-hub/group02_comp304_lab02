package com.example.group02_comp304sec004_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    private NurseViewModel nurseViewModel;
    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private TextInputEditText department;
    private TextInputEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");
        nurseViewModel = new ViewModelProvider(this).get(NurseViewModel.class);

    }

    public void createNurseButton(View view){

        firstName = (TextInputEditText)findViewById(R.id.firstName);
        lastName = (TextInputEditText)findViewById(R.id.lastName);
        department = (TextInputEditText)findViewById(R.id.department);
        password = (TextInputEditText)findViewById(R.id.password);

        if (firstName.getText().toString().length() != 0 && lastName.getText().toString().length() != 0
                && department.getText().toString().length() != 0 &&
                password.getText().toString().length() != 0 ) {
            String firstNameValue = firstName.getText().toString();
            String lastNameValue = lastName.getText().toString();
            String departmentValue = department.getText().toString();
            String passwordValue = password.getText().toString();

            nurseViewModel.insert(new Nurse(firstNameValue, lastNameValue, departmentValue, passwordValue));
            finish();
        }
        else {
            Toast.makeText(RegistrationActivity.this, "Please ensure there are no null values", Toast.LENGTH_SHORT).show();
        }



    }
}