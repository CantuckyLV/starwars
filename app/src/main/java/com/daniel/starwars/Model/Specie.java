package com.daniel.starwars.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Specie implements Serializable {

    @SerializedName("name")
    public String name;
    @SerializedName("classification")
    public String classification;
    @SerializedName("designation")
    public String designation;
    @SerializedName("average_height")
    public String averageHeight;
    @SerializedName("average_lifespan")
    public String averageLifespan;
    @SerializedName("eye_colors")
    public String hair_colors;
    @SerializedName("hairColors")
    public String skin_colors;
    @SerializedName("skinColors")
    public String language;
    @SerializedName("language")
    public String maxAtmospheringSpeed;
    @SerializedName("homeworld")
    public String homeworld;

    @SerializedName("people")
    public List<String> people;
    @SerializedName("films")
    public List<String> films;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Specie{" +
                "name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", designation='" + designation + '\'' +
                ", averageHeight='" + averageHeight + '\'' +
                ", averageLifespan='" + averageLifespan + '\'' +
                ", hair_colors='" + hair_colors + '\'' +
                ", skin_colors='" + skin_colors + '\'' +
                ", language='" + language + '\'' +
                ", maxAtmospheringSpeed='" + maxAtmospheringSpeed + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", people=" + people +
                ", films=" + films +
                '}';
    }
}
