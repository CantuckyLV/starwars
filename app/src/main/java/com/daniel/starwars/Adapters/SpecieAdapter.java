package com.daniel.starwars.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.starwars.Model.Specie;
import com.daniel.starwars.R;

import java.util.ArrayList;

public class SpecieAdapter extends RecyclerView.Adapter<SpecieAdapter.ItemViewHolder> {
    private ArrayList<Specie> species;
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.simple_item, parent, false);
        return new SpecieAdapter.ItemViewHolder(itemView,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Specie specie = species.get(position);
        TextView specieName = holder.specieName;

        specieName.setText(specie.getName());
    }

    @Override
    public int getItemCount() {
        return species.size();
    }

    public SpecieAdapter(ArrayList<Specie> items, OnItemClickListener mOnItemClickListener) {
        this.species = items;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onSpecieClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView specieName;
        SpecieAdapter.OnItemClickListener onItemClickListener;
        public ItemViewHolder(View itemView, SpecieAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            specieName = itemView.findViewById(R.id.item_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onSpecieClick(getAdapterPosition());
        }
    }
}

