package com.akostikov.app;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.akostikov.app.data.FerryDBHelper;
import com.akostikov.app.menu_pages.FerrysPageActivity;
import com.akostikov.app.menu_pages.InfoPageActivity;
import com.akostikov.app.menu_pages.IslandsPageActivity;

import java.util.ArrayList;
import java.util.List;


public class ResultsActivity extends AppCompatActivity {

    private static String departure;
    private static String arrival;

    private DataAdapter dataAdapter;
    private RecyclerView recyclerView;
    private ArrayList<ListItem> tableItems;
    FerryDBHelper dbHelper;

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
        setSupportActionBar(toolbar);

        // Set the Up button action
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler);

        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fill data adapter
        tableItems = new ArrayList<>();
        dataAdapter = new DataAdapter(tableItems);
        recyclerView.setAdapter(dataAdapter);

        // Get departure and arrival from intent
        Bundle args = getIntent().getExtras();
        departure = args.getString("dep");
        arrival = args.getString("arr");

            toolbar.setTitle(departure + " - " + arrival);
        // Get data from DB
        new GetDataFromDbTask().execute(tableItems);

        dataAdapter.notifyDataSetChanged();
    }

    // Async task to get data from DB
    class GetDataFromDbTask extends AsyncTask<List<ListItem>, Void, Void> {

        @Override
        protected Void doInBackground(List<ListItem>... listItems) {
            // Instance of db
            dbHelper = new FerryDBHelper(getApplicationContext());
            dbHelper.getDataFromDB(departure, arrival, tableItems);
            dbHelper.close();

            return null;
        }
    }


}

