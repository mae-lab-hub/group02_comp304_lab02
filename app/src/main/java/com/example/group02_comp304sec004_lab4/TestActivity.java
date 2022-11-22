package com.example.group02_comp304sec004_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class TestActivity extends AppCompatActivity {

    private TestViewModel testViewModel;
    private TextInputEditText patientID;
    private TextInputEditText nurseID;
    private TextInputEditText BPL;
    private TextInputEditText BPH;
    private TextInputEditText temperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testViewModel = new ViewModelProvider(this).get(TestViewModel.class);

    }

    public void createTestButton(View view) {

        patientID = (TextInputEditText)findViewById(R.id.patientID);
        nurseID = (TextInputEditText)findViewById(R.id.nurseID);
        BPL = (TextInputEditText)findViewById(R.id.BPL);
        BPH = (TextInputEditText)findViewById(R.id.BPH);
        temperature = (TextInputEditText)findViewById(R.id.temperature);


        if (patientID.getText().toString().length() != 0 && nurseID.getText().toString().length() != 0
                && BPL.getText().toString().length() != 0 &&
                BPH.getText().toString().length() != 0 &&
                temperature.getText().toString().length() != 0) {
            int patientIDValue = Integer.parseInt(patientID.getText().toString());
            int nurseIDValue = Integer.parseInt(nurseID.getText().toString());
            String BPLValue = BPL.getText().toString();
            String BPHValue = BPH.getText().toString();
            String temperatureValue = temperature.getText().toString();
            testViewModel.insert(new Test(patientIDValue, nurseIDValue, BPLValue, BPHValue, temperatureValue));
            finish();
        }
        else {
            Toast.makeText(TestActivity.this, "Please ensure there are no null values", Toast.LENGTH_SHORT).show();
        }
    }

}