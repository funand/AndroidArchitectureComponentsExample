package com.example.prince.databaseassignment.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prince.databaseassignment.R;
import com.example.prince.databaseassignment.Database.StudentInformation;
import com.example.prince.databaseassignment.DataAdapter.StudentListAdapter;
import com.example.prince.databaseassignment.ViewModel.StudentViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentViewModel mViewModel;
    private TextView studentName;
    private TextView studentRollNumber;

    Button done, display;

    List<StudentInformation> dataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        done = (Button) findViewById(R.id.done);
        display = (Button) findViewById(R.id.display);

        mViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        onDoneBTNClicked();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentName = (EditText) findViewById(R.id.studentName);
                studentRollNumber = (EditText) findViewById(R.id.rollNumber);
                mViewModel.insert(studentName.getText().toString(), studentRollNumber.getText().toString());
                subscribeStudents();

            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView rv = findViewById(R.id.recycled);
                LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
                rv.setLayoutManager(llm);
                dataset = mViewModel.loadAllStudents();
                StudentListAdapter adapter = new StudentListAdapter(MainActivity.this, dataset);
                rv.setAdapter(adapter);
            }
        });
    }

    void onDoneBTNClicked() {
        mViewModel.createDb();
    }

    private void subscribeStudents() {
        mViewModel.getStudentResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String result) {
//                studentTextView.setText(result);
            }
        });
    }

}
