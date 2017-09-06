package com.example.albert.myrestaurants;

import android.content.Context;
import android.widget.ArrayAdapter;


public class MyRestaurantsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;

    public MyRestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }

    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String cuisines = mCuisines[position];
        return String.format("%s \nServes great: %s", restaurant, cuisines);
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }
}
