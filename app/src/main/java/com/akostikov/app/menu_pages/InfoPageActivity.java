package com.akostikov.app.menu_pages;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.TextView;

import com.akostikov.app.R;
import java.util.logging.Logger;


public class InfoPageActivity extends AppCompatActivity {

    private TextView github;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_info_page, menu);
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
            case R.id.islands:  {
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
        setContentView(R.layout.info_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        github = findViewById(R.id.github_link);
        registerForContextMenu(github);

        github.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkInChrome();
            }
        });

        github.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    void openLinkInChrome() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.GREEN);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(github.getText().toString()));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.open:
                openLinkInChrome();
                return true;
            case R.id.copy:

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
