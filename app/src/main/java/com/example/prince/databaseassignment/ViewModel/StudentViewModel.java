package com.example.prince.databaseassignment.ViewModel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.example.prince.databaseassignment.Database.AppDatabase;
import com.example.prince.databaseassignment.Database.DatabaseInitializer;
import com.example.prince.databaseassignment.Database.StudentInformation;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    public LiveData<String> student;
    public List<StudentInformation> studentList;
    private AppDatabase mDb;

    public StudentViewModel(@NonNull Application application) {
        super(application);
    }

    public void createDb() {
        mDb = AppDatabase.getInMemoryDatabase(this.getApplication());
        DatabaseInitializer.populateAsync(mDb);
        subscribeToDbChanges();
    }

    public void insert(String studentName, String rollNumber) {
        StudentInformation student = new StudentInformation();
        student.studentName = studentName;
        student.rollNumber = rollNumber;
        mDb.studentModel().insertStudent(student);
    }

    public List<StudentInformation> loadAllStudents() {
        studentList = mDb.studentModel().loadAllStudents();
        return studentList;
    }

    private void subscribeToDbChanges() {
        LiveData<List<StudentInformation>> studentData = mDb.studentModel().loadAllStudentsLive();

        student = Transformations.map(studentData, new Function<List<StudentInformation>, String>() {
            @Override
            public String apply(List<StudentInformation> studentInfo) {

                StringBuilder sb = new StringBuilder();
                for (StudentInformation student : studentInfo) {
                    sb.append(student.studentName + "  " + student.rollNumber + "\n");
                }
                return sb.toString();
            }
        });

    }

    public LiveData<String> getStudentResult() {
        return student;
    }
}
