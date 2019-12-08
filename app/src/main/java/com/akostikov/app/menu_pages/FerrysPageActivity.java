package com.akostikov.app.menu_pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.akostikov.app.R;

public class FerrysPageActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.ferry_companies: {
                intent = new Intent(this, FerrysPageActivity.class);
                break;
            }
            case R.id.islands: {
                intent = new Intent(this, IslandsPageActivity.class);
                break;
            }
        }
        if (intent != null) startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ferrys_page);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(R.string.ferry_companies);
    }
}
