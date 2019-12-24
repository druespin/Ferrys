package com.akostikov.app.menu_pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.akostikov.app.R;


public class IslandsPageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1, tv2, tv3,
            samuiText, phanganText, taoText;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_islands_page, menu);
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
        setContentView(R.layout.islands_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        samuiText = findViewById(R.id.samui_text);
        phanganText = findViewById(R.id.phangan_text);
        taoText = findViewById(R.id.tao_text);

        samuiText.setOnClickListener(this);
        phanganText.setOnClickListener(this);
        taoText.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.samui_text: {
                    expandCollapseInfo(samuiText);
                    break;
                }
                case R.id.phangan_text: {
                    expandCollapseInfo(phanganText);
                    break;
                }
                case R.id.tao_text: {
                    expandCollapseInfo(taoText);
                    break;
                }
            }
    }


    void expandCollapseInfo(TextView tv)   {
        if (tv.getMaxLines() == 3) {
            tv.setMaxLines(30);
        } else {
            tv.setMaxLines(3);
        }

    }
}
