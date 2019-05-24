package com.example.wonderfulnature;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewAllNature extends RecyclerView.Adapter<CardViewAllNature.CardViewViewHolder> {

    private Context context;
    private ArrayList<Nature> listNature;

    public ArrayList<Nature> getListNature() {
        return listNature;
    }

    public void setListNature(ArrayList<Nature> listNature) {
        this.listNature = listNature;
    }

    public CardViewAllNature(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_style, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder cardViewViewHolder, int i) {
        final Nature nature = getListNature().get(i);


        Glide.with(context)
                .load(nature.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.photo);

        cardViewViewHolder.the_title.setText(nature.getThe_title());
        cardViewViewHolder.short_description.setText(nature.getShort_description());

        cardViewViewHolder.favorite_button.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallBack() {
            @Override
            public boolean onItemClicked(View view, int position) {
                cardViewViewHolder.favorite_button.setBackgroundColor(Color.rgb(13, 191, 255));
                cardViewViewHolder.favorite_button.setText("Favorited");
                Toast.makeText(context, "Favorite " + getListNature().get(position).getThe_title(), Toast.LENGTH_SHORT).show();
                return false;
            }
        }));


        cardViewViewHolder.share_button.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallBack() {
            @Override
            public boolean onItemClicked(View view, int position) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                String shareBody = "[ SHARE ]\n" + getListNature().get(position).getThe_title() +
                        "\n\nFollow my github account : https://www.github.com/maulanarasoky" +
                        "\nAnd check my blog : https://www.mul-code.blogspot.com";
                share.putExtra(Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(share, "Share Using"));
                return false;
            }
        }));

        cardViewViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsNature.class);

                intent.putExtra("Name", nature.getThe_title());
                intent.putExtra("Long Description", nature.getLong_description());
                intent.putExtra("Short Description", nature.getShort_description());
                intent.putExtra(DetailsNature.PHOTO, nature.getPhoto());
                intent.putExtra(DetailsNature.OTHER_PHOTO_ONE, nature.getOther_img_one());
                intent.putExtra(DetailsNature.OTHER_PHOTO_TWO, nature.getOther_img_two());
                intent.putExtra(DetailsNature.OTHER_PHOTO_THREE, nature.getOther_img_three());
                intent.putExtra("Other Name", nature.getOther_name());
                intent.putExtra("Location", nature.getLocation());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListNature().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView the_title, short_description;
        Button favorite_button, share_button;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            the_title = itemView.findViewById(R.id.the_title);
            short_description = itemView.findViewById(R.id.short_description);
            favorite_button = itemView.findViewById(R.id.favorite_button);
            share_button = itemView.findViewById(R.id.share_button);
        }
    }
}
