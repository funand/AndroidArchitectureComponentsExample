package com.example.prince.databaseassignment.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface StudentDao {

    @Query("SELECT * from StudentInformation where rollNumber = :rollNumber")
    StudentInformation loadStudentByRollNumber(String rollNumber);

    @Query("SELECT * from StudentInformation")
    List<StudentInformation> loadAllStudents();

    @Query("SELECT * from StudentInformation")
    LiveData<List<StudentInformation>> loadAllStudentsLive();

    @Insert(onConflict = IGNORE)
    void insertStudent(StudentInformation StudentInformation);

    @Query("DELETE FROM StudentInformation")
    void deleteAllStudents();

}
