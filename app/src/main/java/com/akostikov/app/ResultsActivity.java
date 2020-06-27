package com.akostikov.app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akostikov.app.presenter.ResultsPresenter;
import com.akostikov.app.menu_pages.FerrysPageActivity;
import com.akostikov.app.menu_pages.InfoPageActivity;
import com.akostikov.app.menu_pages.IslandsPageActivity;
import com.akostikov.app.model.ListItem;

import java.util.ArrayList;

public class ResultsActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId())
        {
            default: return super.onOptionsItemSelected(item);

            case R.id.ferry_companies: {
                intent = new Intent(this, FerrysPageActivity.class);
                break;
            }
            case R.id.islands:  {
                intent = new Intent(this, IslandsPageActivity.class);
                break;
            }
            case R.id.info:  {
                intent = new Intent(this, InfoPageActivity.class);
                break;
            }
        }
        startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);

        // Set the Up button action
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fill data adapter
        final ArrayList<ListItem> tableItems = new ArrayList<>();
        DataAdapter dataAdapter = new DataAdapter(tableItems);
        recyclerView.setAdapter(dataAdapter);

        // Get departure and arrival from intent
        Bundle args = getIntent().getExtras();
        assert args != null;
        String departure = args.getString("dep");
        String arrival = args.getString("arr");

        toolbar.setTitle(departure + " - " + arrival);

        // Get data from DB
        ResultsPresenter mvp = new ResultsPresenter(
                ResultsActivity.this,
                departure,
                arrival,
                tableItems);
        mvp.getItemsFromSQLite();
        dataAdapter.notifyDataSetChanged();
    }
}

