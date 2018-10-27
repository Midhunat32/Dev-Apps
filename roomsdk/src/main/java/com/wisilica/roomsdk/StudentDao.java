package com.wisilica.roomsdk;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM student WHERE id = :id LIMIT 1")
    Student findStudentById(int id);

    @Query("SELECT * FROM student WHERE student_name = :fullName")
    Student findStudentByName(String fullName);

    @Query("SELECT * FROM student")
    List<Student> getAllStudent();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Student student);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Student... student);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Student student);

    @Query("DELETE FROM student")
    void deleteAll();

}
