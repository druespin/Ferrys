package com.akostikov.app;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.akostikov.app.menu_pages.FerrysPageActivity;
import com.akostikov.app.menu_pages.InfoPageActivity;
import com.akostikov.app.menu_pages.IslandsPageActivity;


public class MainActivity extends AppCompatActivity {

    String departure, arrival;
    Spinner spin1, spin2;
    Button btnSearch;

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

            default: return false;

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
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inflate a menu to be displayed in the toolbar
        // toolbar.inflateMenu(R.menu.main_menu);

        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        btnSearch = findViewById(R.id.search);

        // Invoke method to get departure and arrival from spinners
        setupSpinner();

        // Click 'Search' button
        btnSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){

            if (departure.equals("- DEPARTURE -")) {
                Toast.makeText(getApplicationContext(), "Departure not selected", Toast.LENGTH_SHORT).show();
            }

            else if (arrival.equals("- ARRIVAL -")) {
                Toast.makeText(getApplicationContext(), "Arrival not selected", Toast.LENGTH_SHORT).show();
            }

            else if (departure.equals(arrival))  {
                Toast.makeText(getApplicationContext(), "Try again please", Toast.LENGTH_SHORT).show();
            }

            else {

                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("dep", departure);
                intent.putExtra("arr", arrival);
                startActivity(intent);
            }

        }
    });
    }


    private void setupSpinner() {

        ArrayAdapter spinAdapter1 = ArrayAdapter.createFromResource(this,
                R.array.departure_items, android.R.layout.simple_spinner_item);

        ArrayAdapter spinAdapter2 = ArrayAdapter.createFromResource(this,
                R.array.arrival_items, android.R.layout.simple_spinner_item);

        spinAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin1.setAdapter(spinAdapter1);
        spin2.setAdapter(spinAdapter2);

        // Get Departure from Spinner 1
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                departure = parent.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Get Arrival from Spinner 2
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                arrival = spin2.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}


