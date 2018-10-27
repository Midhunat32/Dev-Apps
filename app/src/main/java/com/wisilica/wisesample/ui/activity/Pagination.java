package com.wisilica.wisesample.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wisilica.wisesample.R;

public class Pagination extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagination);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            startActivity(new Intent(this,Pagination.class));
        });


        OperationData data =new OperationData();
        data.setType("");





    }

}
