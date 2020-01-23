package com.daniel.starwars.Presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daniel.starwars.Model.SWCharacter;
import com.daniel.starwars.Model.Movie;
import com.daniel.starwars.Model.Planet;
import com.daniel.starwars.Model.Specie;
import com.daniel.starwars.Model.Starship;
import com.daniel.starwars.Model.Vehicle;
import com.daniel.starwars.SWRequestQueue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MovieActivityPresenter {
    private MovieActivityPresenter.View view;
    private ArrayList<SWCharacter> SWCharacters = new ArrayList<>();
    private ArrayList<Planet> planets = new ArrayList<>();
    private ArrayList<Starship> starships = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Specie> species = new ArrayList<>();
    private int numberOfRequests = 0;
    private String BASE_URL = "https://swapi.co/api/";
    private Movie movie = new Movie();

    public MovieActivityPresenter(MovieActivityPresenter.View view) {
        this.view = view;
    }

    public void setupMovie(Bundle bundle){
        if(bundle != null) {
            movie = (Movie) bundle.getSerializable("movie");
            view.setupMovieView(movie);
        }
    }

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            //TODO handle errors: connection and such
        }
    };
    public void getMovieLists(Context context){
        view.showProgressDialog();
        RequestQueue queue = SWRequestQueue.getInstance(context).getRequestQueue();
        String petitionURL="";
        //Characters
        for(int i=0; i<movie.getCharacters().size();i++){
            petitionURL = movie.getCharacters().get(i);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(petitionURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null){
                        VolleyLog.wtf(response.toString(), "utf-8");
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        SWCharacters.add(gson.fromJson(response.toString(), SWCharacter.class));
                    }

                }
            }, errorListener) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Priority getPriority() {
                    return Priority.NORMAL;
                }
            };
            queue.add(jsonObjectRequest);

        }
        //Planets
        for(int i=0; i<movie.getPlanets().size();i++){
            petitionURL = movie.getPlanets().get(i);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(petitionURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null){
                        VolleyLog.wtf(response.toString(), "utf-8");
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        planets.add(gson.fromJson(response.toString(),Planet.class));
                    }

                }
            }, errorListener) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Priority getPriority() {
                    return Priority.NORMAL;
                }
            };
            queue.add(jsonObjectRequest);

        }
        //Starships
        for(int i=0; i<movie.getStarships().size();i++){
            petitionURL = movie.getStarships().get(i);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(petitionURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null){
                        VolleyLog.wtf(response.toString(), "utf-8");
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        starships.add(gson.fromJson(response.toString(),Starship.class));
                    }

                }
            }, errorListener) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Priority getPriority() {
                    return Priority.NORMAL;
                }
            };
            queue.add(jsonObjectRequest);

        }
        //Vehicles
        for(int i=0; i<movie.getVehicles().size();i++){
            petitionURL = movie.getVehicles().get(i);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(petitionURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null){
                        VolleyLog.wtf(response.toString(), "utf-8");
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        vehicles.add(gson.fromJson(response.toString(),Vehicle.class));
                    }

                }
            }, errorListener) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Priority getPriority() {
                    return Priority.NORMAL;
                }
            };
            queue.add(jsonObjectRequest);

        }
        //Species
        for(int i=0; i<movie.getSpecies().size();i++){
            petitionURL = movie.getSpecies().get(i);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(petitionURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if(response!=null){
                        VolleyLog.wtf(response.toString(), "utf-8");
                        GsonBuilder builder = new GsonBuilder();
                        Gson gson = builder.create();
                        species.add(gson.fromJson(response.toString(), Specie.class));
                    }

                }
            }, errorListener) {

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public Priority getPriority() {
                    return Priority.NORMAL;
                }
            };
            queue.add(jsonObjectRequest);

        }
        queue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
                try {
                    if (request.getCacheEntry() != null) {
                        String cacheValue = new String(request.getCacheEntry().data, "UTF-8");
                        numberOfRequests++;
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (numberOfRequests == movie.getCharacters().size()+movie.getPlanets().size()+movie.getStarships().size()+movie.getVehicles().size()+movie.getSpecies().size()) {
                    Log.e("acabo","lol");
                    numberOfRequests = 0;
                    view.hideProgressDialog();
                    view.setupCharacters(SWCharacters);
                    view.setupPlanets(planets);
                    view.setupStarships(starships);
                    view.setupVehicles(vehicles);
                    view.setupSpecies(species);
                }
            }
        });

    }
    public void characterSelected (int position){
        SWCharacter tmpSWCharacter = SWCharacters.get(position);
        view.goToCharacter(tmpSWCharacter);
    }
    public void planetSelected (int position){
        Planet tmpPlanet= planets.get(position);
        view.goToPlanet(tmpPlanet);
    }

    public interface View{
        void showProgressDialog();
        void hideProgressDialog();
        void setupMovieView(Movie movie);
        void setupCharacters(ArrayList<SWCharacter> SWCharacters);
        void setupPlanets(ArrayList<Planet> planets);
        void setupStarships(ArrayList<Starship> starships);
        void setupVehicles(ArrayList<Vehicle> vehicles);
        void setupSpecies(ArrayList<Specie> species);
        void goToCharacter(SWCharacter SWCharacter);
        void goToPlanet(Planet planet);
    }
}
