package com.example.albert.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    public static final String TAG = RestaurantsActivity.class.getSimpleName();
    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;


    private String[] restaurants = new String[] {"Que Pasa", "Artcaffe", "Kibandaski", "Amber Hotel",
            "Anita's Kitchen", "KFC", "Galito's", "Equinox", "Brew Bistro", "Cake Plaza", "Java",
            "Ocean Basket", "Subway", "Chipotle", "Urban Burger", "Domino's Pizza", "Chicken Inn"};
    private String[] cuisines = new String[] {"Italian food", "Urban mix", "Local food", "three course meals", "Anita's food", "Southern Fried chicken", "Spicey fried chicken", "I do not know", "Choma and a cold one", "Masala fries", "Coffee and pastries", "Sea food", "Array of sandwiches", "something nice", "Gourmet burgers", "Italian pizza's", "Array of different fried chicken"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });
        //Intent calls the Intent made in main activity and shows the location.
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near: " + location);
    }
}
