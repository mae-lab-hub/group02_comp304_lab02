package com.example.group02_comp304sec004_lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class UpdateInfoActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_info);
        setTitle("Patients List");

        RecyclerView recyclerView = findViewById(R.id.recycler_view_patient);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        PatientAdapter adapter = new PatientAdapter();

        recyclerView.setAdapter(adapter);

        patientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(@Nullable List<Patient> patients) {
                //update recycler
                adapter.setPatients(patients);
                if (patients.size()>0)
                    Toast.makeText(UpdateInfoActivity.this, String.valueOf(patients.size()), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(UpdateInfoActivity.this, "Empty", Toast.LENGTH_SHORT).show();
            }
        });


    }
}