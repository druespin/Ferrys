package com.akostikov.app.menu_pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.akostikov.app.R;

public class FerrysPageActivity extends AppCompatActivity {


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
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
