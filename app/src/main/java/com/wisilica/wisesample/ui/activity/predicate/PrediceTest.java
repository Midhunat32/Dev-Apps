package com.wisilica.wisesample.ui.activity.predicate;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wisilica.wisesample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PrediceTest extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predice_test);
        List<Student>students =new ArrayList<>();

        Student s1=new Student(10,25);
        Student s2=new Student(10,28);
        Student s3=new Student(10,30);
        students.addAll(Arrays.asList(new Student[]{s1,s2,s3}));
        filterStudents(students, moreAge(35));
    }


    public  Predicate<Student>moreAge(Integer age){
        return p->p.getAge()>age;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Student> filterStudents (List<Student> students, Predicate<Student> predicate) {
        return students.stream().filter( predicate ).collect(Collectors.<Student>toList());
    }


    public class Student{
        int id;
        int age;

        public Student(int id, int age) {
            this.id = id;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
