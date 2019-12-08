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
import android.widget.TextView;

import com.akostikov.app.data.FerryDBHelper;
import java.util.ArrayList;
import java.util.List;


public class ResultsActivity extends AppCompatActivity {

    private Toolbar toolbar;
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
        //if (item.getItemId() == R.layout.ferrys_page) {
        Intent intent = new Intent(this, MenuOptionActivity.class);
        startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inflate a menu to be displayed in the toolbar
        toolbar.inflateMenu(R.menu.main_menu);

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

