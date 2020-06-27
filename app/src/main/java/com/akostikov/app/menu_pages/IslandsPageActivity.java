package com.akostikov.app.menu_pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.akostikov.app.R;


public class IslandsPageActivity extends Activity implements View.OnClickListener {

    private TextView tv_samui, tv_phangan, tv_tao;
    private TextView samuiText, phanganText, taoText;

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
        toolbar.inflateMenu(R.menu.menu_for_islands_page);

        tv_samui = findViewById(R.id.tv_samui);
        tv_phangan = findViewById(R.id.tv_phangan);
        tv_tao = findViewById(R.id.tv_tao);

        samuiText = findViewById(R.id.samui_text);
        phanganText = findViewById(R.id.phangan_text);
        taoText = findViewById(R.id.tao_text);

        tv_samui.setOnClickListener(this);
        tv_phangan.setOnClickListener(this);
        tv_tao.setOnClickListener(this);

        samuiText.setOnClickListener(this);
        phanganText.setOnClickListener(this);
        taoText.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_samui: {
                    startMapPageActivity("samui");
                    break;
                }
                case R.id.tv_phangan: {
                    startMapPageActivity("phangan");
                    break;
                }
                case R.id.tv_tao: {
                    startMapPageActivity("tao");
                    break;
                }

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

    void startMapPageActivity(String island)   {
        Intent intent = new Intent(getApplicationContext(), MapPageActivity.class);
        intent.putExtra("island", island);
        startActivity(intent);
    }

    void expandCollapseInfo(TextView tv)   {
        if (tv.getMaxLines() == 3) {
            tv.setMaxLines(30);
        } else {
            tv.setMaxLines(3);
        }

    }
}
