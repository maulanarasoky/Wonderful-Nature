package com.example.wonderfulnature;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAllNature extends RecyclerView.Adapter<GridAllNature.GridViewHolder> {

    private Context context;
    private ArrayList<Nature> listNature;

    public ArrayList<Nature> getListNature() {
        return listNature;
    }

    public void setListNature(ArrayList<Nature> listNature) {
        this.listNature = listNature;
    }

    public GridAllNature(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_style, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int position) {
        Glide.with(context)
                .load(getListNature().get(position).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(gridViewHolder.photo);
    }

    @Override
    public int getItemCount() {
        return getListNature().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView photo;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
        }
    }
}
