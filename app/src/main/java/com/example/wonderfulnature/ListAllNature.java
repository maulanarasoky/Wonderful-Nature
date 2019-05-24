package com.example.wonderfulnature;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListAllNature extends RecyclerView.Adapter<ListAllNature.CategoryViewHolder> {

    private Context context;
    private ArrayList<Nature> listNature;

    public ArrayList<Nature> getListNature() {
        return listNature;
    }

    public void setListNature(ArrayList<Nature> listNature) {
        this.listNature = listNature;
    }

    public ListAllNature(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_style, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        final Nature nature = getListNature().get(position);

        categoryViewHolder.the_title.setText(getListNature().get(position).getThe_title());
        categoryViewHolder.short_description.setText(getListNature().get(position).getShort_description());

        Glide.with(context)
                .load(getListNature().get(position).getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(categoryViewHolder.photo);

        categoryViewHolder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsNature.class);

                intent.putExtra("Name", nature.getThe_title());
                intent.putExtra("Long Description", nature.getLong_description());
                intent.putExtra("Short Description", nature.getShort_description());
                intent.putExtra(DetailsNature.PHOTO, nature.getPhoto());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListNature().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView the_title, short_description;
        ImageView photo;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            the_title = itemView.findViewById(R.id.the_title);
            short_description = itemView.findViewById(R.id.short_description);
            photo = itemView.findViewById(R.id.photo);
        }
    }
}
