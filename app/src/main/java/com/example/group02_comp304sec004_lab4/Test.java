package com.example.group02_comp304sec004_lab4;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "test_table")
public class Test {

    @PrimaryKey(autoGenerate = true)
    private int testID;

    //TODO: link the tables using foreignkeys
    @NonNull
    private int patientID;

    @NonNull
    private int nurseID;

    @NonNull
    private String BPL;

    @NonNull
    private String BPH;

    @NonNull
    private String temperature;


    public Test(@NonNull int patientID, @NonNull int nurseID, @NonNull String BPL, @NonNull String BPH, @NonNull String temperature) {
        this.patientID = patientID;
        this.nurseID = nurseID;
        this.BPL = BPL;
        this.BPH = BPH;
        this.temperature = temperature;
    }



    public void setTestID(int testID) {this.testID = testID;}

    public int getTestID() {
        return testID;
    }

    public int getPatientID() {
        return patientID;
    }

    @NonNull
    public int getNurseID() {
        return nurseID;
    }

    @NonNull
    public String getBPL() {
        return BPL;
    }

    @NonNull
    public String getBPH() {
        return BPH;
    }

    @NonNull
    public String getTemperature() {
        return temperature;
    }

}
