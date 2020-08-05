package com.akostikov.app.results_view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akostikov.app.R;
import com.akostikov.app.database.RoomItem;
import com.akostikov.app.ferrys.FerrysPageActivity;
import com.akostikov.app.islands.IslandsPageActivity;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class ResultsActivity extends Activity implements Toolbar.OnMenuItemClickListener {

    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private String departure, arrival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get departure and arrival from intent
        Bundle args = getIntent().getExtras();
        if (args != null) {
            departure = args.getString("dep");
            arrival = args.getString("arr");

            if (departure != null && arrival != null) {
                toolbar.setTitle(departure + " - " + arrival);
                getItemsAndShowResults(departure, arrival);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getItemId() == R.id.swap_direction) {
            final String swap = departure;
            departure = arrival;
            arrival = swap;
            toolbar.setTitle(departure + " - " + arrival);
            getItemsAndShowResults(departure, arrival);
        }
        return true;
    }

    private void getItemsAndShowResults(String departure, String arrival) {

        try {
            final ResultsRepo repo = new ResultsRepo(departure, arrival);
            final List<RoomItem> items = repo.getItems();

            if (!items.isEmpty()) {
                DataAdapter adapter = new DataAdapter(items);
                recyclerView.setAdapter(adapter);
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

