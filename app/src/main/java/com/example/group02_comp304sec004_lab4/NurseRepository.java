package com.example.group02_comp304sec004_lab4;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseRepository {

    public NurseDao nurseDao;
    private LiveData<List<Nurse>> allNurses;

    public NurseRepository(Application application)
    {
        NurseDatabase db = NurseDatabase.getDatabase(application);
        nurseDao = db.nurseDao();
        allNurses = nurseDao.getAllNurses();
    }

    public LiveData<List<Nurse>> getAllNurses() {return allNurses; }

    public void insert(Nurse nurse) {
        NurseDatabase.databaseWriteExecutor.execute(() -> {
            nurseDao.insert(nurse);
        });
    }

    public LiveData<Nurse> findbyNurseID(int nurseID) {return nurseDao.getByNurseID(nurseID); }
}
