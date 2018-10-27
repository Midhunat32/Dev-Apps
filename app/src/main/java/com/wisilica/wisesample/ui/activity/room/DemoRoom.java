package com.wisilica.wisesample.ui.activity.room;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wisilica.roomsdk.Student;
import com.wisilica.roomsdk.StudentDB;
import com.wisilica.roomsdk.TestRoomData;
import com.wisilica.wisesample.R;
import com.wisilica.wisesample.ui.adapter.RoomAdapter;

import java.util.List;


public class DemoRoom extends AppCompatActivity {

    RecyclerView recyclerview;
    RoomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //List<Student>list =  TestRoomData.newInstance(this).readData();
        //adapter =new RoomAdapter(list);
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);
    }


}
