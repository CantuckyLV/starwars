package com.daniel.starwars.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.starwars.Model.Movie;
import com.daniel.starwars.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemViewHolder> {
    private ArrayList<Movie> movies;
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public MovieAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.movie_item, parent, false);
        return new ItemViewHolder(itemView,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ItemViewHolder holder, int position) {
        Movie movie = movies.get(position);
        TextView movieName = holder.movieName;
        TextView episodeNumber = holder.episodeNumber;

        movieName.setText(movie.getTitle());
        episodeNumber.setText(Integer.toString(movie.getEpisodeID()));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public MovieAdapter(ArrayList<Movie> items, OnItemClickListener mOnItemClickListener) {
        this.movies = items;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView movieName;
        public TextView episodeNumber;
        OnItemClickListener onItemClickListener;
        public ItemViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movie_title);
            episodeNumber = itemView.findViewById(R.id.episode_number);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
