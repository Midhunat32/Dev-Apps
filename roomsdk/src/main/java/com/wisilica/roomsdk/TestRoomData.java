package com.wisilica.roomsdk;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;


public class TestRoomData {

    public static TestRoomData newInstance = null;

    Context mContext;
    StudentDB database;
    StudentDao dao;

    public static TestRoomData newInstance(Context mContext){
        if(newInstance == null){
            newInstance = new TestRoomData(mContext);
        }
        return newInstance;
    }


    public TestRoomData(Context mContext) {
        this.mContext = mContext;
        initDataBase();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                setData();
            }
        });
        thread.start();

    }

    private void initDataBase() {
        database = Room.databaseBuilder(mContext, StudentDB.class, "db_student")
                .allowMainThreadQueries()   //Allows room to do operation on main thread
                .build();
    }

    public void setData(){
        dao= database.getStudentDetails();
        deleteList();
        Student student1=new Student("Device 1","122222222");
        Student student2=new Student("Device 2","222222222");
        Student student3=new Student("Device 3","333333333");
        Student student4=new Student("Device 4","444444444");
        Student student5=new Student("Device 5","858555555");
        dao.insert(student1,student2,student3,student4,student5);
    }

    public List<Student> readData(){
      // return dao.getAllStudent();
        return null;
    }

    public void deleteList(){
        if (dao!=null){
            dao.deleteAll();
        }
    }


}
