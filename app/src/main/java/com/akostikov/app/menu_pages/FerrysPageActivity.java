package com.akostikov.app.menu_pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.akostikov.app.R;

public class FerrysPageActivity extends FragmentActivity implements // View.OnClickListener,
                                                            Toolbar.OnMenuItemClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ferrys_page);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_for_ferrys_page);
        toolbar.setTitle(R.string.ferry_companies);
        toolbar.setOnMenuItemClickListener(this);

        ViewPager viewPager = findViewById(R.id.ferry_pager);
        PagerAdapter pagerAdapter = new FerryPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_ferrys_page, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent intent = new Intent();

        if (item.getItemId() == R.id.islands) {
            intent = new Intent(this, IslandsPageActivity.class);
        }
        startActivity(intent);
        return true;
    }

    class FerryPagerAdapter extends FragmentStatePagerAdapter {

        FerryPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new FerryPagerFragment(position);
        }

    }

/*

    @Override
    public void onClick(View v) {
        String ferryType;

        switch (v.getId()) {
            default: return;

            case R.id.raja_logo: {
                ferryType ="raja";
                break;
            }
            case R.id.lomprayah_logo: {
                ferryType ="lomprayah";
                break;
            }
            case R.id.seatran_logo: {
                ferryType = "seatran";
                break;
            }
            case R.id.songserm_logo: {
                ferryType = "songserm";
                break;
            }
            case R.id.haadrin_logo: {
                ferryType = "haadrin";
                break;
            }
        }
        if (ferryType != null) {
            Intent intent = new Intent(getApplicationContext(), FerryDetailActivity.class);
            intent.putExtra("ferry", ferryType);
            startActivity(intent);
        }
    }

 */

}

