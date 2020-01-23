package com.daniel.starwars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.daniel.starwars.Adapters.MovieAdapter;
import com.daniel.starwars.Model.Movie;
import com.daniel.starwars.Presenter.MainActivityPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View, MovieAdapter.OnItemClickListener {
    private ProgressDialog progress;
    private RecyclerView rvMovies;
    private MainActivityPresenter presenter;
    MovieAdapter movieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        setupView();
    }

    private void setupView(){
        rvMovies = findViewById(R.id.rv_movies);
        progress = new ProgressDialog(this);
        presenter.requestMovies(getApplicationContext());
    }
    @Override
    public void showProgressDialog(){
        progress.setTitle("Loading Star Wars movies");
        progress.setMessage("Please Wait");
        progress.setCancelable(false);
        progress.show();
    }
    @Override
    public void hideProgressDialog(){
        progress.dismiss();
    }
    @Override
    public void setupMovieList(ArrayList<Movie> movies) {
        movieAdapter = new MovieAdapter(movies,this);
        rvMovies.setAdapter(movieAdapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void goToMovie(Movie movie) {
        Intent intent = new Intent(MainActivity.this, MovieInfoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("movie", movie);
        intent.putExtras(bundle);
        startActivity(intent);
        //finish();
    }

    @Override
    public void onItemClick(int position) {
        presenter.movieSelected(position);
    }
}
