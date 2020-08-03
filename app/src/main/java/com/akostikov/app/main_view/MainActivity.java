package com.akostikov.app.main_view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;

import com.akostikov.app.R;
import com.akostikov.app.menu_pages.FerrysPageActivity;
import com.akostikov.app.menu_pages.IslandsPageActivity;
import com.akostikov.app.results_view.ResultsActivity;


public class MainActivity extends FragmentActivity implements Toolbar.OnMenuItemClickListener {

    private static final String GITHUB_LINK_TEXT = "https://github.com/druespin/Ferrys";
    private String departure, arrival;
    private Spinner spin1, spin2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);

        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        ImageView swapFields = findViewById(R.id.swap_fields);
        Button btnSearch = findViewById(R.id.search_btn);

        ImageView githubLink = findViewById(R.id.github_link);
        if (githubLink != null) {
            registerForContextMenu(githubLink);
        }

//        githubLink.setOnClickListener(v -> openLinkInChrome());
//        githubLink.setOnLongClickListener(v -> false);

        setupSpinners();

        swapFields.setOnClickListener(v -> {
            if (departure != null && arrival != null) {
                int swap = spin1.getSelectedItemPosition();
                spin1.setSelection(spin2.getSelectedItemPosition());
                spin2.setSelection(swap);
            }
        });

        btnSearch.setOnClickListener(v -> {
            setupSpinners();
            doSearch(departure, arrival);
        });
    }


    private void doSearch(String departure, String arrival) {

        if (departure.equals("SELECT DEPARTURE")) {
            Toast.makeText(this, "Departure not selected", Toast.LENGTH_SHORT).show();
        }
        else if (arrival.equals("SELECT ARRIVAL")) {
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

    void openLinkInChrome() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.BLACK);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(GITHUB_LINK_TEXT));
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
            default: return false;

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

