package com.example.albert.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;

public class RestaurantsActivity extends AppCompatActivity {
    public static final String TAG = RestaurantsActivity.class.getSimpleName();
    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.locationEditText) TextView mLocationTextView;
    private String[] restaurants = new String[] {"Que Pasa", "Artcaffe", "Kibandaski", "Amber Hotel",
            "Anita's Kitchen", "KFC", "Galito's", "Equinox", "Brew Bistro", "Cake Plaza", "Java",
            "Ocean Basket", "Subway", "Chipotle", "Urban Burger", "Domino's Pizza", "Chicken Inn"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });
        //Intent calls the Intent made in main activity and shows the location.
//        Intent intent = getIntent();
//        String location = intent.getStringExtra("location");
//        mLocationTextView.setText("Here are all the restaurants near: " + location);
    }
}
