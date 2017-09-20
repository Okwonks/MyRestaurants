package com.example.albert.myrestaurants;

/**
 * Created by albert on 9/11/17.
 */

public class Constants {
    public static final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
    public static final String YELP_BASE_URL = "https://api.yelp.com/v3/businesses/search?term=restaurant";
    public static final String YELP_LOCATION_QUERY_PARAMETER = "location";
    public static final String PREFERENCE_LOCATION_KEY = "location";
    public static final String FIREBASE_SEARCHED_CHILD_LOCATION = "searchedLocation";
    public static final String FIREBASE_CHILD_RESTAURANT = "restaurants";
}
