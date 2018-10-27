package com.wisilica.roomsdk;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;


import java.util.ArrayList;
import java.util.List;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDB extends RoomDatabase {

    public abstract StudentDao getStudentDetails();

}

