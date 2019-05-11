package com.tj.banklistfromserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tj.banklistfromserver.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    private void bindViews() {
    }

    private void setupEvents() {
    }

    private void setValues() {
    }


}
