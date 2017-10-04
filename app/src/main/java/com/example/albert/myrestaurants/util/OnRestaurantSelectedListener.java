package com.example.albert.myrestaurants.util;

import com.example.albert.myrestaurants.models.Restaurant;

import java.util.ArrayList;

public interface OnRestaurantSelectedListener {
    void onRestaurantSelectedListener(Integer position, ArrayList<Restaurant> restaurants);
}
