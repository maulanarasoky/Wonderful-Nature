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
    private ArrayList<Nature> listNature;
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        category = findViewById(R.id.category);
        category.setHasFixedSize(true);

//        listNature.addAll(AllNatureData.getDataNature());
//        showCardView();

        listNature = new ArrayList<>();

        if (savedInstanceState == null) {
//            setActionBarTitle("Mode List");
            listNature.addAll(AllNatureData.getDataNature());
            showCardView();
            mode = R.id.cardView;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Nature> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            listNature.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
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
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.list:
                title = "List View";
                showList();
                break;
            case R.id.grid:
                title = "Grid View";
                showGrid();
                break;
            case R.id.cardView:
                title = "Card View";
                showCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, listNature);
        outState.putInt(STATE_MODE, mode);
    }
}
