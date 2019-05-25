package com.example.wonderfulnature;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsNature extends AppCompatActivity implements View.OnClickListener {

    ImageView img;
    TextView the_title, long_description, short_description, other_name, location, time_zone, coordinates;
    Button contact_us, follow_button, lets_travel;
    String title;

    public static String PHOTO;

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_nature);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = new Intent();

        title = getIntent().getStringExtra("Name");
        String long_desc = getIntent().getStringExtra("Long Description");
        String short_desc = getIntent().getStringExtra("Short Description");
        String otr_name = getIntent().getStringExtra("Other Name");
        String loc = getIntent().getStringExtra("Location");
        String time = getIntent().getStringExtra("Time Zone");
        String coordinate = getIntent().getStringExtra("Coordinates");

        img = findViewById(R.id.photo);
        the_title = findViewById(R.id.the_title);
        long_description = findViewById(R.id.description);
        short_description = findViewById(R.id.short_description);
        other_name = findViewById(R.id.other_name);
        location = findViewById(R.id.location);
        time_zone = findViewById(R.id.time_zone);
        coordinates = findViewById(R.id.coordinates);

        contact_us = findViewById(R.id.contact_us);
        contact_us.setOnClickListener(this);

        follow_button = findViewById(R.id.follow_button);
        follow_button.setOnClickListener(this);

        lets_travel = findViewById(R.id.lets_travel);
        lets_travel.setOnClickListener(this);

        the_title.setText(title);
        long_description.setText(long_desc);
        short_description.setText(short_desc);
        other_name.setText(otr_name);
        location.setText(loc);
        time_zone.setText(time);
        coordinates.setText(coordinate);

        String photo = getIntent().getStringExtra(PHOTO);
        Glide.with(this).load(photo).into(img);

        setActionBarTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.contact_us:
                String phone_number = "082160049893";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone_number));
                startActivity(dialPhoneIntent);
                break;
            case R.id.follow_button:
                Uri uri = Uri.parse("http://instagram.com/_u/maulana_rasoky");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/maulana_rasoky")));
                }
                break;
            case R.id.lets_travel:
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/html");
                intent.setData(Uri.parse("mailto:maulana.rasoky25@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Let's Travel !");
                intent.putExtra(Intent.EXTRA_TEXT, "I want to get travel to " + title +"\n\nThis is my data :" +
                        "\n\nFirst Name   : .............." +
                        "\nLast Name   : .............." +
                        "\nOld                 : .............." +
                        "\nBirth Date     : .............." +
                        "\nAddress        : .............." +
                        "\n\nAt this moment with my data above, I am ready for the journey !");

                startActivity(Intent.createChooser(intent, "Send Email"));
                break;
        }
    }
}
