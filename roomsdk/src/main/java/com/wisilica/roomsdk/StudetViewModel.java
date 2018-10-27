package com.wisilica.roomsdk;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class StudetViewModel extends AndroidViewModel {
    StudentDao studentDao;
    public LiveData<List<Student>> moviesLiveData;

    public StudetViewModel(@NonNull Application application) {
        super(application);

    }
    public LiveData<List<Student>> getMoviesList() {
        return moviesLiveData;
    }

    public void insert(Student... movies) {
        //studentDao.insert(movies);
    }

    public void update(Student movie) {
        studentDao.update(movie);
    }

    public void deleteAll() {
        studentDao.deleteAll();
    }

}
