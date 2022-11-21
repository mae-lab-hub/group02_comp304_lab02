package com.example.group02_comp304sec004_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button nurseLogin;
    EditText textNurseID;
    EditText textNursePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Patient Information");

        nurseLogin = findViewById(R.id.btnNurseLogin);
        textNurseID = findViewById(R.id.textNurseID);
        textNursePassword = findViewById(R.id.textNursePassword);
    }
}