package com.example.group02_comp304sec004_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void addPatientButton(View view){

        Intent intent = new Intent(this,PatientActivity.class);
        startActivity(intent);
    }

    public void editPatientButton(View view){

        Intent intent = new Intent(this,UpdateInfoActivity.class);
        startActivity(intent);
    }
    public void addTestButton(View view){

    }
}