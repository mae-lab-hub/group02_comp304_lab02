package com.example.group02_comp304sec004_lab4;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TestRepository {

    public TestDao testDao;
    private LiveData<List<Test>> allTests;

    public TestRepository(Application application)
    {
        TestDatabase db = TestDatabase.getDatabase(application);
        testDao = db.testDao();
        allTests = testDao.getAllTests();
    }

    public LiveData<List<Test>> getAllTests() {return allTests; }

    public void insert(Test test) {
        TestDatabase.databaseWriteExecutor.execute(() -> {
            testDao.insert(test);
        });
    }

    public LiveData<Test> findByTestID(int testID) {return testDao.getByTestID(testID); }

}
