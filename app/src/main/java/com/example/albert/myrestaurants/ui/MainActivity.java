package com.example.albert.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

import com.example.albert.myrestaurants.Constants;
import com.example.albert.myrestaurants.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    /*private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;*/
    private DatabaseReference mSearchedLocationReference;
    private ValueEventListener mSearchedLocationReferenceListener;

    @Bind(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_SEARCHED_CHILD_LOCATION);

        mSearchedLocationReferenceListener = mSearchedLocationReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot locationSnapshot: dataSnapshot.getChildren()) {
                    String location = locationSnapshot.getValue().toString();
                    Log.d("location updated", "Location: " + location);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // If error occurs, UI is updated here.
            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface walkwayFont = Typeface.createFromAsset(getAssets(), "fonts/walkway-bold.ttf");
        mAppNameTextView.setTypeface(walkwayFont);

        /*mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();*/

        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSearchedLocationReference.removeEventListener(mSearchedLocationReferenceListener);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();

            saveLocationToFirebase(location);
//            if (!(location).equals("")) {
//                addToSharedPreferences(location); // THis stores the shared preference of the location that is to be used in retrieving restaurants
//            }
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }

    public void saveLocationToFirebase(String location) {
        mSearchedLocationReference.push().setValue(location);
    }
/*    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCE_LOCATION_KEY, location).apply();
    }*/
}
