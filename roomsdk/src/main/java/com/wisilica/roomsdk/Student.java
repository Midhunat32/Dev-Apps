package com.wisilica.roomsdk;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "student", indices = {@Index(value = "student_name", unique = true)})
public class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int studentId;

    @ColumnInfo(name = "student_name")
    @NonNull
    public String studentName;

    @ColumnInfo(name = "phone_no")
    @NonNull
    public String phoneNo;

    public Student(@NonNull String studentName, @NonNull String phoneNo) {
        this.studentName = studentName;
        this.phoneNo = phoneNo;
    }

}
