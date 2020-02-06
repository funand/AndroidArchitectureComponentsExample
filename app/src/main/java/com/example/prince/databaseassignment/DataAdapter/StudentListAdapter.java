package com.example.prince.databaseassignment.DataAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prince.databaseassignment.R;
import com.example.prince.databaseassignment.Database.StudentInformation;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {
    List<StudentInformation> dataset;
    Context context;

    public StudentListAdapter(Context context, List<StudentInformation> dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.students, parent, false);
        StudentViewHolder svh = new StudentViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final StudentInformation studentInformation = dataset.get(position);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "STUDENT NAME: " + studentInformation.studentName, Toast.LENGTH_LONG).show();
            }
        });

        holder.rollNumber.setText(studentInformation.rollNumber);
        holder.StudentName.setText(studentInformation.studentName);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        View layout;
        TextView StudentName;
        TextView rollNumber;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView.findViewById(R.id.studentLayout);
            this.StudentName = itemView.findViewById(R.id.Name);
            this.rollNumber = itemView.findViewById(R.id.Number);
        }
    }
}
