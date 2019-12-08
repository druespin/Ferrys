package com.akostikov.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.logging.Logger;

class IslandsPageActivity extends AppCompatActivity {

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
            case R.layout.ferrys_page: {
                intent = new Intent(this, FerrysPageActivity.class);
                break;
            }
            case R.layout.islands_page: {
                intent = new Intent(this, IslandsPageActivity.class);
                break;
            }
        }
        Logger.getLogger("Item check------");
        if (intent != null) startActivity(intent);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.islands_page);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
