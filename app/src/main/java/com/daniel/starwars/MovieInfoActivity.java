package com.daniel.starwars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.daniel.starwars.Adapters.CharacterAdapter;
import com.daniel.starwars.Adapters.PlanetAdapter;
import com.daniel.starwars.Adapters.SpecieAdapter;
import com.daniel.starwars.Adapters.StarshipAdapter;
import com.daniel.starwars.Adapters.VehicleAdapter;
import com.daniel.starwars.Model.SWCharacter;
import com.daniel.starwars.Model.Movie;
import com.daniel.starwars.Model.Planet;
import com.daniel.starwars.Model.Specie;
import com.daniel.starwars.Model.Starship;
import com.daniel.starwars.Model.Vehicle;
import com.daniel.starwars.Presenter.MovieActivityPresenter;

import java.util.ArrayList;

public class MovieInfoActivity extends AppCompatActivity implements MovieActivityPresenter.View, CharacterAdapter.OnItemClickListener, PlanetAdapter.OnItemClickListener, StarshipAdapter.OnItemClickListener, VehicleAdapter.OnItemClickListener, SpecieAdapter.OnItemClickListener {
    private ProgressDialog progress;
    private TextView episodeNumber,movieName,movieDirector,movieProducer,movieDate, movieCrawl;
    private Button tmpButton;
    private RecyclerView rvCharacters, rvPlanets, rvStarships, rvVehicles, rvSpecies;
    private MovieActivityPresenter presenter;
    private CharacterAdapter characterAdapter;
    private PlanetAdapter planetAdapter;
    private StarshipAdapter starshipAdapter;
    private VehicleAdapter vehicleAdapter;
    private  SpecieAdapter specieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        presenter = new MovieActivityPresenter(this);
        initializeView();
    }

    private void initializeView(){
        episodeNumber = findViewById(R.id.episode_number);
        movieName = findViewById(R.id.movie_name);
        movieDirector = findViewById(R.id.movie_director);
        movieProducer = findViewById(R.id.movie_producer);
        movieDate = findViewById(R.id.movie_date);
        movieCrawl = findViewById(R.id.movie_crawl);
        rvCharacters = findViewById(R.id.rv_characters);
        rvPlanets = findViewById(R.id.rv_planets);
        rvStarships = findViewById(R.id.rv_starships);
        rvVehicles = findViewById(R.id.rv_vehicles);
        rvSpecies = findViewById(R.id.rv_species);
        progress = new ProgressDialog(this);
        Bundle bundle = getIntent().getExtras();
        presenter.setupMovie(bundle);

    }

    @Override
    public void showProgressDialog() {
        progress.setTitle("Loading Movie info");
        progress.setMessage("Please Wait");
        progress.setCancelable(false);
        progress.show();
    }

    @Override
    public void hideProgressDialog() {
        progress.dismiss();
    }

    @Override
    public void setupMovieView(Movie movie) {
        episodeNumber.setText(Integer.toString(movie.getEpisodeID()));
        movieName.setText(movie.getTitle());
        movieDirector.setText(movie.getDirector());
        movieProducer.setText(movie.getProducer());
        movieDate.setText(movie.getReleaseDate());
        movieCrawl.setText(movie.getOpeningCrawl());
        presenter.getMovieLists(MovieInfoActivity.this);
    }

    @Override
    public void setupCharacters(ArrayList<SWCharacter> SWCharacters) {
        characterAdapter = new CharacterAdapter(SWCharacters,this);
        rvCharacters.setAdapter(characterAdapter);
        rvCharacters.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setupPlanets(ArrayList<Planet> planets) {
        planetAdapter = new PlanetAdapter(planets,this);
        rvPlanets.setAdapter(planetAdapter);
        rvPlanets.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void setupStarships(ArrayList<Starship> starships) {
        starshipAdapter = new StarshipAdapter(starships, this);
        rvStarships.setAdapter(starshipAdapter);
        rvStarships.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setupVehicles(ArrayList<Vehicle> vehicles) {
        vehicleAdapter = new VehicleAdapter(vehicles, this);
        rvVehicles.setAdapter(vehicleAdapter);
        rvVehicles.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setupSpecies(ArrayList<Specie> species) {
        specieAdapter = new SpecieAdapter(species, this);
        rvSpecies.setAdapter(specieAdapter);
        rvSpecies.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void goToCharacter(SWCharacter SWCharacter) {
        Intent intent = new Intent(MovieInfoActivity.this, DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", SWCharacter);
        bundle.putInt("view",0);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void goToPlanet(Planet planet) {
        Intent intent = new Intent(MovieInfoActivity.this, DetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("item", planet);
        bundle.putInt("view",1);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onCharacterClick(int position) {
        presenter.characterSelected(position);
    }

    @Override
    public void onPlanetClick(int position) {
        presenter.planetSelected(position);
    }

    @Override
    public void onStarshipClick(int position) {
        Log.e("starship","click");
    }

    @Override
    public void onVehicleClick(int position) {
        Log.e("vehicle","click");
    }

    @Override
    public void onSpecieClick(int position) {
        Log.e("specie","click");
    }
}
