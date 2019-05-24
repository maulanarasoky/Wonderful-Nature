package com.example.wonderfulnature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView category;
    private ArrayList<Nature> listNature = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        category = findViewById(R.id.category);
        category.setHasFixedSize(true);

        listNature.addAll(AllNatureData.getDataNature());
        showCardView();
    }
    public void showList() {
        category.setLayoutManager(new LinearLayoutManager(this));
        ListAllNature listAllNature = new ListAllNature(this);
        listAllNature.setListNature(listNature);
        category.setAdapter(listAllNature);
    }
    public void showGrid() {
        category.setLayoutManager(new GridLayoutManager(this, 2));
        GridAllNature gridAllNature = new GridAllNature(this);
        gridAllNature.setListNature(listNature);
        category.setAdapter(gridAllNature);
    }
    public void showCardView() {
        category.setLayoutManager(new LinearLayoutManager(this));
        CardViewAllNature cardViewAllNature = new CardViewAllNature(this);
        cardViewAllNature.setListNature(listNature);
        category.setAdapter(cardViewAllNature);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list:
                showList();
                break;
            case R.id.grid:
                showGrid();
                break;
            case R.id.cardView:
                showCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
