package com.example.wonderfulnature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsNature extends AppCompatActivity {

    ImageView img, other_img_one, other_img_two, other_img_three;
    TextView the_title, long_description, short_description, other_name, location;

    public static String PHOTO;
    public static String OTHER_PHOTO_ONE;
    public static String OTHER_PHOTO_TWO;
    public static String OTHER_PHOTO_THREE;

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_nature);

        Intent intent = new Intent();

        String title = getIntent().getStringExtra("Name");
        String long_desc = getIntent().getStringExtra("Long Description");
        String short_desc = getIntent().getStringExtra("Short Description");
        String otr_name = getIntent().getStringExtra("Other Name");
        String loc = getIntent().getStringExtra("Location");

        img = findViewById(R.id.photo);
        the_title = findViewById(R.id.the_title);
        long_description = findViewById(R.id.description);
        short_description = findViewById(R.id.short_description);
        other_name = findViewById(R.id.other_name);
        location = findViewById(R.id.location);
        other_img_one = findViewById(R.id.other_img_one);
        other_img_two = findViewById(R.id.other_img_two);
        other_img_three = findViewById(R.id.other_img_three);

        the_title.setText(title);
        long_description.setText(long_desc);
        short_description.setText(short_desc);
        other_name.setText(otr_name);
        location.setText(loc);

        String photo = getIntent().getStringExtra(PHOTO);
        Glide.with(this).load(photo).into(img);

        String otr_img_one = getIntent().getStringExtra(OTHER_PHOTO_ONE);
        Glide.with(this).load(otr_img_one).into(other_img_one);

        String otr_img_two = getIntent().getStringExtra(OTHER_PHOTO_TWO);
        Glide.with(this).load(otr_img_two).into(other_img_two);

        String otr_img_three = getIntent().getStringExtra(OTHER_PHOTO_THREE);
        Glide.with(this).load(otr_img_three).into(other_img_three);

        setActionBarTitle(title);
    }
}
