package com.akostikov.app.menu_pages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.akostikov.app.R;

public class FerryDetailActivity extends Activity implements Toolbar.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ferry_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(this);

        ImageView ferryImage = findViewById(R.id.ferry_image);
        TextView ferryText = findViewById(R.id.ferry_text);

        String ferryType = getIntent().getExtras().getString("ferry");

        switch (ferryType)  {
            case "raja": {
                ferryImage.setImageResource(R.drawable.raja_foto);
                ferryText.setText(R.string.raja_text);
                break;
            }
            case "lomprayah": {
                ferryImage.setImageResource(R.drawable.lomprayah_foto);
                ferryText.setText(R.string.lomprayah_text);
                break;
            }
            case "seatran": {
                ferryImage.setImageResource(R.drawable.seatran_foto);
                ferryText.setText(R.string.seatran_text);
                break;
            }
            case "songserm": {
                ferryImage.setImageResource(R.drawable.songserm_foto);
                ferryText.setText(R.string.songserm_text);
                break;
            }
            case "haadrin": {
                ferryImage.setImageResource(R.drawable.haadrin_foto);
                ferryText.setText(R.string.haadrin_text);
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_ferrys_page, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
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

}
