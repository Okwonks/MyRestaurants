package com.example.albert.myrestaurants.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.albert.myrestaurants.R;

import butterknife.ButterKnife;

public class RestaurantListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);
    }

}