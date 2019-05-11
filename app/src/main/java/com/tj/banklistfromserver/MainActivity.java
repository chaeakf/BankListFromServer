package com.tj.banklistfromserver;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tj.banklistfromserver.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {

    }

    private void setupEvents() {

    }

    private void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }


}
