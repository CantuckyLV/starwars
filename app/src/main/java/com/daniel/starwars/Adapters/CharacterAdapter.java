package com.daniel.starwars.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.starwars.Model.SWCharacter;
import com.daniel.starwars.R;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ItemViewHolder>{
    private ArrayList<SWCharacter> SWCharacters;
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.simple_item, parent, false);
        return new CharacterAdapter.ItemViewHolder(itemView,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        SWCharacter SWCharacter = SWCharacters.get(position);
        TextView characterName = holder.characterName;

        characterName.setText(SWCharacter.getName());
    }

    @Override
    public int getItemCount() {
        return SWCharacters.size();
    }

    public CharacterAdapter(ArrayList<SWCharacter> items, OnItemClickListener mOnItemClickListener) {
        this.SWCharacters = items;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onCharacterClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView characterName;
        CharacterAdapter.OnItemClickListener onItemClickListener;
        public ItemViewHolder(View itemView, CharacterAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            characterName = itemView.findViewById(R.id.item_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onCharacterClick(getAdapterPosition());
        }
    }
}
