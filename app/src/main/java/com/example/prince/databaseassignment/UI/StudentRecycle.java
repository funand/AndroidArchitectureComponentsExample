package com.example.prince.databaseassignment.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.prince.databaseassignment.R;
import com.example.prince.databaseassignment.Database.StudentInformation;
import com.example.prince.databaseassignment.DataAdapter.StudentListAdapter;

import java.util.List;

public class StudentRecycle extends AppCompatActivity {

    RecyclerView rv;
    List<StudentInformation> dataset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rv = findViewById(R.id.recycled);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        StudentListAdapter adapter = new StudentListAdapter(this, dataset);
        rv.setAdapter(adapter);

    }


}
