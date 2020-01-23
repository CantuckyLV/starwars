package com.daniel.starwars.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.starwars.Model.Starship;
import com.daniel.starwars.R;

import java.util.ArrayList;

public class StarshipAdapter extends RecyclerView.Adapter<StarshipAdapter.ItemViewHolder>  {
    private ArrayList<Starship> starships;
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.simple_item, parent, false);
        return new StarshipAdapter.ItemViewHolder(itemView,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Starship starship = starships.get(position);
        TextView starshipName = holder.starshipName;

        starshipName.setText(starship.getName());
    }

    @Override
    public int getItemCount() {
        return starships.size();
    }

    public StarshipAdapter(ArrayList<Starship> items, OnItemClickListener mOnItemClickListener) {
        this.starships = items;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onStarshipClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView starshipName;
        StarshipAdapter.OnItemClickListener onItemClickListener;
        public ItemViewHolder(View itemView, StarshipAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            starshipName = itemView.findViewById(R.id.item_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onStarshipClick(getAdapterPosition());
        }
    }
}
