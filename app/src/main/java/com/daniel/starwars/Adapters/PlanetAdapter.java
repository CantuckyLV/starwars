package com.daniel.starwars.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.starwars.Model.Planet;
import com.daniel.starwars.R;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ItemViewHolder>{
    private ArrayList<Planet> planets;
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.simple_item, parent, false);
        return new PlanetAdapter.ItemViewHolder(itemView,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Planet planet = planets.get(position);
        TextView planetName = holder.planetName;

        planetName.setText(planet.getName());
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public PlanetAdapter(ArrayList<Planet> items, OnItemClickListener mOnItemClickListener) {
        this.planets = items;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onPlanetClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView planetName;
        PlanetAdapter.OnItemClickListener onItemClickListener;
        public ItemViewHolder(View itemView, PlanetAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            planetName = itemView.findViewById(R.id.item_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        onItemClickListener.onPlanetClick(getAdapterPosition());
    }
    }
}
