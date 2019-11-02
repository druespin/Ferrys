package com.akostikov.datab;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.akostikov.datab.data.FerryDBHelper;
import java.util.ArrayList;
import java.util.List;


public class ResultsActivity extends Activity {

    private static String departure;
    private static String arrival;

    private DataAdapter dataAdapter;
    private RecyclerView recyclerView;
    private ArrayList<ListItem> tableItems;
    FerryDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

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

