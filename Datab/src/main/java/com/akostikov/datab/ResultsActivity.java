package com.akostikov.datab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.akostikov.datab.data.FerryDBHelper;
import java.util.ArrayList;



public class ResultsActivity extends Activity {

    String departure, arrival;
    RecyclerView recyclerView;

    final ArrayList<ListItem> tableItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        recyclerView = findViewById(R.id.recycler);

        // Initialize DB
        final FerryDBHelper dbHelper = new FerryDBHelper(getApplicationContext());

        // Fill data adapter
        final DataAdapter dataAdapter = new DataAdapter(this, tableItems);
        recyclerView.setAdapter(dataAdapter);

        // Get departure and arrival from intent
        Bundle args = getIntent().getExtras();
        departure = args.getString("dep");
        arrival = args.getString("arr");

        // Get data from DB
        dbHelper.getWritableDatabase();

        dbHelper.showInfo(departure, arrival, tableItems);
        dataAdapter.notifyDataSetChanged();

        dbHelper.close();
    }
}

