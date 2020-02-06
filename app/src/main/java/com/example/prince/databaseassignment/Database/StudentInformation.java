package com.example.prince.databaseassignment.Database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class StudentInformation {
    @PrimaryKey
    @NonNull
    public String studentName;
    public String rollNumber;

}
