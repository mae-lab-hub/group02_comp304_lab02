package com.example.group02_comp304sec004_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class TestListActivity extends AppCompatActivity {


    private TestViewModel testViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_test);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        TestAdapter adapter = new TestAdapter();

        recyclerView.setAdapter(adapter);

        testViewModel = new ViewModelProvider(this).get(TestViewModel.class);
        testViewModel.getAllTests().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                //update recycler
                adapter.setTests(tests);
                if (tests.size()>0)
                    Toast.makeText(TestListActivity.this, String.valueOf(tests.size()), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(TestListActivity.this, "Empty", Toast.LENGTH_SHORT).show();
            }
        });


    }
}