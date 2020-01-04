package com.akostikov.app.menu_pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.akostikov.app.R;

public class MapPageActivity extends AppCompatActivity {

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
            case R.id.islands: {
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
        setContentView(R.layout.map_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView mapView = findViewById(R.id.map_view);
        String island = getIntent().getExtras().getString("island");

        if (island != null)
        {
            switch (island) {

                default: toolbar.setTitle("No map");
                    break;

                case "samui": {
                    toolbar.setTitle("Koh Samui");
                    mapView.setImageResource(R.drawable.samui_map);
                    break;
                }
                case "phangan": {
                    toolbar.setTitle("Koh Phangan");
                    mapView.setImageResource(R.drawable.phangan_map);
                    break;
                }
                case "tao": {
                    toolbar.setTitle("Koh Tao");
                    mapView.setImageResource(R.drawable.tao_map);
                    break;
                }
            }
        }

    }
}
