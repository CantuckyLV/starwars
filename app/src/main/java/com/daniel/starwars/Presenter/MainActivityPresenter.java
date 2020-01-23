package com.daniel.starwars.Presenter;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daniel.starwars.Model.Movie;
import com.daniel.starwars.Model.MovieResponse;
import com.daniel.starwars.SWRequestQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivityPresenter {
    private View view;
    ArrayList<Movie> movies = new ArrayList<>();
    String BASE_URL = "https://swapi.co/api/";

    public MainActivityPresenter(View view) {
        this.view = view;
    }

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //TODO handle errors: connection and such
        }
    };
    public void requestMovies(Context context) {
        view.showProgressDialog();
        RequestQueue queue = SWRequestQueue.getInstance(context).getRequestQueue();
        String movieUrl = String.format(BASE_URL + "films");

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(movieUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response!=null){
                    VolleyLog.wtf(response.toString(), "utf-8");
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    view.hideProgressDialog();
                    //Log.e("ekjhwkj",response.toString());
                    MovieResponse movieResponse = gson.fromJson(response.toString(),MovieResponse.class);
                    movies = movieResponse.getResults();
                    view.setupMovieList(movies);
                }

            }
        }, errorListener) {

            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };
        queue.add(jsonObjectRequest);

    }
    public void movieSelected(int position){
        Movie tmpMovie = movies.get(position);
        view.goToMovie(tmpMovie);
    }

    public interface View{
        void showProgressDialog();
        void hideProgressDialog();
        void setupMovieList(ArrayList<Movie> movies);
        void goToMovie(Movie movie);
    }
}
