package org.ecaib.rottentomatoesclient2016;

import android.net.Uri;

import android.support.annotation.Nullable;

import java.io.IOException;

class RottenTomatoesAPI {
    private final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    private final String API_KEY = "9htuhtcb4ymusd73d4z6jxcj";

    String getPeliculesMesVistes(String pais) {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("lists")
                .appendPath("movies")
                .appendPath("box_office.json")
                .appendQueryParameter("country", pais)
                .appendQueryParameter("apikey", API_KEY)
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    String getProximesEstrenes(String pais) {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("lists")
                .appendPath("movies")
                .appendPath("upcoming.json")
                .appendQueryParameter("country", pais)
                .appendQueryParameter("apikey", API_KEY)
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    @Nullable
    private String doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
