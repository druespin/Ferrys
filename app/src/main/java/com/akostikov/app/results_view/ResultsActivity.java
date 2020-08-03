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
import com.akostikov.app.menu_pages.FerrysPageActivity;
import com.akostikov.app.menu_pages.IslandsPageActivity;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class ResultsActivity extends Activity implements Toolbar.OnMenuItemClickListener {

    private RecyclerView recyclerView;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get departure and arrival from intent
        Bundle args = getIntent().getExtras();
        if (args != null) {
            String departure = args.getString("dep");
            String arrival = args.getString("arr");

            toolbar.setTitle(departure + " - " + arrival);

            // Get data from DB
            try {
                final ResultsRepo repo = new ResultsRepo(departure, arrival);
                final List<RoomItem> items = repo.getItems();

                if (!items.isEmpty()) {
                    adapter = new DataAdapter(items);
                    recyclerView.setAdapter(adapter);
                }
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
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
        }
        startActivity(intent);
        return true;
    }

}

