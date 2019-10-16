package com.akostikov.datab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {

    String departure, arrival;

    Spinner spin1, spin2;
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        btnSearch = findViewById(R.id.search);


        // Invoke method to get departure and arrival from spinners
        setupSpinner();

        // Click 'Search' button
        btnSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){

            if (departure.equals("-Select-")) {
                Toast.makeText(getApplicationContext(), "Departure not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            if (arrival.equals("-Select-")) {
                Toast.makeText(getApplicationContext(), "Arrival not selected", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!departure.equals("-Select-") && !arrival.equals("-Select-")) {

                Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                intent.putExtra("dep",departure);
                intent.putExtra("arr", arrival);
                startActivity(intent);
            }

        }
    });
    }


    private void setupSpinner() {

        ArrayAdapter spinAdapter1 = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);

        ArrayAdapter spinAdapter2 = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);

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


