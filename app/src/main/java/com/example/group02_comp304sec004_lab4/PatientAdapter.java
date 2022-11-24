package com.example.group02_comp304sec004_lab4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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

        // Delete the selected patient from the patients list and room database
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PatientDatabase db = Room.databaseBuilder(holder.textViewId.getContext(),
                        PatientDatabase.class, "patient_database").allowMainThreadQueries().build();
                PatientDao patientDao = db.patientDao();
                // delete patient from the database
                patientDao.deleteByID(currentPatient.getPatientID());
                // delete patient from the list
                patients.remove(currentPatient);

                notifyDataSetChanged();
            }
        });
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
        private Button btnDelete;

        public PaientHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.text_view_id);
            textViewFirstName = itemView.findViewById(R.id.text_view_firstName);
            textViewLastName = itemView.findViewById(R.id.text_view_lastName);
            textViewDepartment = itemView.findViewById(R.id.text_view_department);
            textViewNurseID = itemView.findViewById(R.id.text_view_nurseID);
            textViewRoom = itemView.findViewById(R.id.text_view_room);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
