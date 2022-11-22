package com.example.group02_comp304sec004_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home Page");

        login = findViewById(R.id.btnLogin);
        register = findViewById(R.id.btnRegister);
    }

    public void loadLoginActivity(View view){
        //changed temp to open the menu activity instead
       // Intent intent = new Intent(this,LoginActivity.class);

        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

    public void loadRegistrationActivity(View view){
        Intent intent = new Intent(this,RegistrationActivity.class);
        startActivity(intent);
    }
}