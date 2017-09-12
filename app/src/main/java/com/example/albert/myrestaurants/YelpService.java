package com.example.albert.myrestaurants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * Created by albert on 9/11/17.
 */

public class YelpService {
    public static void findRestaurants(String location, Callback callback) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .header("Authorization", Constants.YELP_TOKEN)
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
