package com.daniel.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daniel.starwars.Model.Planet;
import com.daniel.starwars.Model.SWCharacter;
import com.daniel.starwars.Presenter.DetailsActivityPresenter;

public class DetailsActivity extends AppCompatActivity implements DetailsActivityPresenter.View {
    private LinearLayout llCharacter, llPlanet;
    private TextView characterName,characterBirth,characterEyes,characterGender,characterHair,characterHeight,characterMass,characterSkin,characterHome;
    private TextView planetName, planetDiameter, planetRotation, planetOrbital, planetGravity, planetPopulation, planetCLimate,planetTerrain;
    private DetailsActivityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        presenter = new DetailsActivityPresenter(this);
        initializeView();
    }
    private void initializeView(){
        Bundle bundle = getIntent().getExtras();
        llCharacter = findViewById(R.id.ll_character);
        llPlanet = findViewById(R.id.ll_planet);
        characterName = findViewById(R.id.character_name);
        characterBirth = findViewById(R.id.character_birth);
        characterEyes = findViewById(R.id.character_eyes);
        characterGender = findViewById(R.id.character_gender);
        characterHair = findViewById(R.id.character_hair);
        characterHeight = findViewById(R.id.character_height);
        characterMass = findViewById(R.id.character_mass);
        characterSkin = findViewById(R.id.character_skin);
        characterHome = findViewById(R.id.character_home);
        planetName = findViewById(R.id.planet_name);
        planetDiameter = findViewById(R.id.planet_diameter);
        planetRotation = findViewById(R.id.planet_rotation);
        planetOrbital = findViewById(R.id.planet_orbital);
        planetGravity = findViewById(R.id.planet_gravity);
        planetPopulation = findViewById(R.id.planet_population);
        planetCLimate = findViewById(R.id.planet_climate);
        planetTerrain = findViewById(R.id.planet_terrain);
        switch (bundle.getInt("view")){
            case 0:
                presenter.setupCharacterDetails(bundle);
                break;
            case 1:
                presenter.setupPlanetDetails(bundle);
                break;
        }


    }
    @Override
    public void setupCharacterView(SWCharacter character) {
        llCharacter.setVisibility(View.VISIBLE);
        llPlanet.setVisibility(View.GONE);
        characterName.setText(character.getName());
        characterBirth.setText(character.getBirthYear());
        characterEyes.setText(character.getEyeColor());
        characterGender.setText(character.getGender());
        characterHair.setText(character.getHairColor());
        characterHeight.setText(character.getHeight());
        characterMass.setText(character.getMass());
        characterSkin.setText(character.getSkinColor());
        characterHome.setText(character.getHomeworld());
    }

    @Override
    public void setupPlanetView(Planet planet) {
        llCharacter.setVisibility(View.GONE);
        llPlanet.setVisibility(View.VISIBLE);
        planetName.setText(planet.getName());
        planetDiameter.setText(planet.getDiameter());
        planetRotation.setText(planet.getRotationPeriod());
        planetOrbital.setText(planet.getOrbitalPeriod());
        planetGravity.setText(planet.getGravity());
        planetPopulation.setText(planet.getPopulation());
        planetCLimate.setText(planet.getClimate());
        planetTerrain.setText(planet.getTerrain());
    }

}
