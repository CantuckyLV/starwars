package com.daniel.starwars.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniel.starwars.Model.Vehicle;
import com.daniel.starwars.R;

import java.util.ArrayList;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ItemViewHolder>{
    private ArrayList<Vehicle> vehicles;
    private OnItemClickListener mOnItemClickListener;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.simple_item, parent, false);
        return new VehicleAdapter.ItemViewHolder(itemView,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Vehicle vehicle = vehicles.get(position);
        TextView vehicleName = holder.vehicleName;

        vehicleName.setText(vehicle.getName());
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

    public VehicleAdapter(ArrayList<Vehicle> items, OnItemClickListener mOnItemClickListener) {
        this.vehicles = items;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onVehicleClick(int position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView vehicleName;
        VehicleAdapter.OnItemClickListener onItemClickListener;
        public ItemViewHolder(View itemView, VehicleAdapter.OnItemClickListener onItemClickListener) {
            super(itemView);
            vehicleName = itemView.findViewById(R.id.item_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onVehicleClick(getAdapterPosition());
        }
    }
}
