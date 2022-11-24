package com.example.group02_comp304sec004_lab4;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patient_table")
public class Patient {

    @PrimaryKey(autoGenerate = true)
    private int patientID;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String department;
    @NonNull
    private int nurseID;
    @NonNull
    private String room;

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Patient(@NonNull String firstName,@NonNull String lastName,@NonNull String department,@NonNull int nurseID,@NonNull String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.nurseID = nurseID;
        this.room = room;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Patient() {

    }

    public void setPatientID(int patientID) {this.patientID = patientID;}

    public int getPatientID() {
        return patientID;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getDepartment() {
        return department;
    }

    public int getNurseID() {
        return nurseID;
    }


    public String getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", nurseID=" + nurseID +
                ", room='" + room + '\'' +
                '}';
    }
}

