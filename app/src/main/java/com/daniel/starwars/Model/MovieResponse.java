package com.daniel.starwars.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieResponse implements Serializable {

    @SerializedName("count")
    public Integer count;
    @SerializedName("results")
    public ArrayList<Movie> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}
