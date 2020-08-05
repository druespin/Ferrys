package com.akostikov.app.ferrys;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.akostikov.app.R;

public class FerrysPageActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ferrys_page);

        ViewPager viewPager = findViewById(R.id.ferry_pager);
        PagerAdapter pagerAdapter = new FerryPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
    }


    static class FerryPagerAdapter extends FragmentStatePagerAdapter {

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

