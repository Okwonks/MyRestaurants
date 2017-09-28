package com.example.albert.myrestaurants.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.albert.myrestaurants.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedRestaurantListActivity extends AppCompatActivity {
    @Bind(R.id.progressBar1) ProgressBar mProgressBar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_restaurant_list);
        ButterKnife.bind(this);
        mProgressBar1.setVisibility(View.INVISIBLE);
    }
}
