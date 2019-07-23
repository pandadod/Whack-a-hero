package com.example.whackahero;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static void extractHero(Context context, final HeroListener listener) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = "https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/all.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Hero> heroes = new ArrayList<>();
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject heroObject = response.getJSONObject(i);
                        JSONObject images = heroObject.getJSONObject("images");
                        String url = images.getString("sm");
                        Hero hero = new Hero(url);
                        heroes.add(hero);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listener.onHeroesLoaded(heroes);
            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                    }
                }

        );
        requestQueue.add(jsonArrayRequest);
    }

    public interface HeroListener {
        void onHeroesLoaded(List<Hero> heroes);
    }
}
