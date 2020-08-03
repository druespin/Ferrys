package com.akostikov.app.menu_pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import com.akostikov.app.R;

public class MapPageActivity extends Activity implements Toolbar.OnMenuItemClickListener {

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
            default: return super.onOptionsItemSelected(item);

            case R.id.ferry_companies: {
                intent = new Intent(this, FerrysPageActivity.class);
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
        setContentView(R.layout.map_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);

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
