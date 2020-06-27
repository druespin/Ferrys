package com.akostikov.app.menu_pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import com.akostikov.app.R;

public class FerrysPageActivity extends Activity implements View.OnClickListener {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_ferrys_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            default: return super.onOptionsItemSelected(item);

            case R.id.info: {
                intent = new Intent(this, InfoPageActivity.class);
                break;
            }
            case R.id.islands: {
                intent = new Intent(this, IslandsPageActivity.class);
                break;
            }
        }
        startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ferrys_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_for_ferrys_page);

        ImageView rajaLogo = findViewById(R.id.raja_logo);
        ImageView lompayahLogo = findViewById(R.id.lomprayah_logo);
        ImageView seatranLogo = findViewById(R.id.seatran_logo);
        ImageView songsermLogo = findViewById(R.id.songserm_logo);
        ImageView haadrinLogo = findViewById(R.id.haadrin_logo);

        rajaLogo.setOnClickListener(this);
        lompayahLogo.setOnClickListener(this);
        seatranLogo.setOnClickListener(this);
        songsermLogo.setOnClickListener(this);
        haadrinLogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.raja_logo: {
                startFerryDetailsActivity("raja");
                break;
            }
            case R.id.lomprayah_logo: {
                startFerryDetailsActivity("lomprayah");
                break;
            }
            case R.id.seatran_logo: {
                startFerryDetailsActivity("seatran");
                break;
            }
            case R.id.songserm_logo: {
                startFerryDetailsActivity("songserm");
                break;
            }
            case R.id.haadrin_logo: {
                startFerryDetailsActivity("haadrin");
                break;
            }
        }
    }

    void startFerryDetailsActivity(String ferryType)   {
        Intent intent = new Intent(getApplicationContext(), FerryDetailActivity.class);
        intent.putExtra("ferry", ferryType);
        startActivity(intent);
    }
}

