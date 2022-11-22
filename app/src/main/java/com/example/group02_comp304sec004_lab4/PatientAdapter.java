package com.example.group02_comp304sec004_lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter  extends RecyclerView.Adapter<PatientAdapter.PaientHolder> {

    private List<Patient> patients = new ArrayList<>();
    @NonNull
    @Override
    public PaientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_item, parent, false);

        return new PaientHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PaientHolder holder, int position) {

        Patient currentPatient = patients.get(position);
        holder.textViewId.setText(String.valueOf(currentPatient.getPatientID()));
        holder.textViewFirstName.setText(currentPatient.getFirstName());
        holder.textViewLastName.setText(currentPatient.getLastName());
        holder.textViewDepartment.setText(currentPatient.getDepartment());
        holder.textViewNurseID.setText(String.valueOf(currentPatient.getNurseID()));
        holder.textViewRoom.setText(currentPatient.getRoom());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
        notifyDataSetChanged();
    }

    class PaientHolder extends RecyclerView.ViewHolder{

        private TextView textViewId;
        private TextView textViewFirstName;
        private TextView textViewLastName;
        private TextView textViewDepartment;
        private TextView textViewNurseID;
        private TextView textViewRoom;

        public PaientHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_view_id);
            textViewFirstName = itemView.findViewById(R.id.text_view_firstName);
            textViewLastName = itemView.findViewById(R.id.text_view_lastName);
            textViewDepartment = itemView.findViewById(R.id.text_view_department);
            textViewNurseID = itemView.findViewById(R.id.text_view_nurseID);
            textViewRoom = itemView.findViewById(R.id.text_view_room);

        }
    }
}
