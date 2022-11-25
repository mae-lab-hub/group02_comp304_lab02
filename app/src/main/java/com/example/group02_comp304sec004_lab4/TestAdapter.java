package com.example.group02_comp304sec004_lab4;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    private List<Test> tests = new ArrayList<>();
    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_item, parent, false);

        return new TestHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {

        Test currentTest = tests.get(position);
        holder.textViewId.setText(String.valueOf(currentTest.getTestID()));
        holder.textViewPatientID.setText(String.valueOf(currentTest.getPatientID()));
        holder.textViewNurseID.setText(String.valueOf(currentTest.getNurseID()));
        holder.textViewBPL.setText(currentTest.getBPL());
        holder.textViewBPH.setText(currentTest.getBPH());
        holder.textViewTemperature.setText(currentTest.getTemperature());

        // Delete the selected patient from the patients list and room database
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestDatabase db = Room.databaseBuilder(holder.textViewId.getContext(),
                        TestDatabase.class, "test_database").allowMainThreadQueries().build();
                TestDao testDao = db.testDao();
                // delete test from the database
                testDao.deleteByID(currentTest.getTestID());
                // delete test from the list
                tests.remove(currentTest);

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
        notifyDataSetChanged();
    }

    class TestHolder extends RecyclerView.ViewHolder{

        private TextView textViewId;
        private TextView textViewPatientID;
        private TextView textViewNurseID;
        private TextView textViewBPL;
        private TextView textViewBPH;
        private TextView textViewTemperature;
        private Button btnDelete;

        public TestHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_view_testID);
            textViewPatientID = itemView.findViewById(R.id.text_view_patientID);
            textViewNurseID = itemView.findViewById(R.id.text_view_nurseID);
            textViewBPL = itemView.findViewById(R.id.text_view_BPL);
            textViewBPH = itemView.findViewById(R.id.text_view_BPH);
            textViewTemperature = itemView.findViewById(R.id.text_view_temperature);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}
