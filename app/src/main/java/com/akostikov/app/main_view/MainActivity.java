package com.akostikov.app.main_view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;

import com.akostikov.app.R;
import com.akostikov.app.ferrys.FerrysPageActivity;
import com.akostikov.app.islands.IslandsPageActivity;
import com.akostikov.app.results_view.ResultsActivity;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private static final String GITHUB_LINK_TEXT = "https://github.com/druespin/Ferrys";
    private String departure, arrival;
    private Spinner spin1, spin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);

        if (savedInstanceState != null) {
            spin1.setSelection(savedInstanceState.getInt("departure"));
            spin2.setSelection(savedInstanceState.getInt("arrival"));
        }

        ImageView ferrysLink = findViewById(R.id.ferrys_link);
        ImageView islandsLink = findViewById(R.id.islands_link);
        ImageView githubLink = findViewById(R.id.github_link);
        ImageView swapFields = findViewById(R.id.swap_fields);
        Button searchBtn = findViewById(R.id.search_btn);

        ferrysLink.setOnClickListener(this);
        islandsLink.setOnClickListener(this);
        githubLink.setOnClickListener(this);
        swapFields.setOnClickListener(this);
        searchBtn.setOnClickListener(this);

        setupSpinners();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("departure", spin1.getSelectedItemPosition());
        outState.putInt("arrival", spin2.getSelectedItemPosition());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.ferrys_link: {
                startActivity(new Intent(this, FerrysPageActivity.class));
                break;
            }
            case R.id.islands_link:  {
                startActivity(new Intent(this, IslandsPageActivity.class));
                break;
            }
            case R.id.github_link: {
                openLinkInChrome();
                break;
            }
            case R.id.search_btn: {
                if (departure != null && arrival != null) {
                    doSearch(departure, arrival);
                }
                break;
            }
            case R.id.swap_fields: {
                if (spin1.getSelectedItem().equals("SELECT DEPARTURE") ||
                        spin2.getSelectedItem().equals("SELECT ARRIVAL")) {
                    Toast.makeText(this, "Departure and Arrival should be selected",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    int swap = spin1.getSelectedItemPosition();
                    spin1.setSelection(spin2.getSelectedItemPosition());
                    spin2.setSelection(swap);
                }
                break;
            }
        }
    }

    private void doSearch(String departure, String arrival) {

        if (departure.contains("DEPARTURE")) {
            Toast.makeText(this, "Departure not selected", Toast.LENGTH_SHORT).show();
        }
        else if (arrival.contains("ARRIVAL")) {
            Toast.makeText(this, "Arrival not selected", Toast.LENGTH_SHORT).show();
        }
        else if (departure.equals(arrival))  {
            Toast.makeText(this, "Departure and Arrival should not match",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("dep", departure);
            intent.putExtra("arr", arrival);
            startActivity(intent);
        }
    }

    private void openLinkInChrome() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.BLACK);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(GITHUB_LINK_TEXT));
    }

    private void setupSpinners() {

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

                arrival = parent.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.open:
                openLinkInChrome();
                return true;
            case R.id.copy:
                ClipboardManager clipboard =
                        (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("github link", GITHUB_LINK_TEXT);
                clipboard.setPrimaryClip(clip);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}

