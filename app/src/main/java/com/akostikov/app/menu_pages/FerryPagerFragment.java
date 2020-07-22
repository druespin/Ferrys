package com.akostikov.app.menu_pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.akostikov.app.R;

public class FerryPagerFragment extends Fragment {

    private int[] images = new int[] {
            R.drawable.raja_foto,
            R.drawable.lomprayah_foto,
            R.drawable.seatran_foto,
            R.drawable.songserm_foto,
            R.drawable.haadrin_foto
    };
    private int[] ferryLogos = new int[] {
            R.drawable.raja,
            R.drawable.lomprayah,
            R.drawable.seatran,
            R.drawable.songserm,
            R.drawable.haadrin_queen
    };
    private int[] ferryRoutes = new int[] {
            R.string.raja_routes,
            R.string.lomprayah_routes,
            R.string.seatran_routes,
            R.string.songserm_routes,
            R.string.haadrin_queen_routes
    };
    private int[] ferryNames = new int[] {
            R.string.raja,
            R.string.lomprayah,
            R.string.seatran,
            R.string.songserm,
            R.string.haadrin_queen,
    };
    private int position;

    FerryPagerFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_pager, container, false);
        ImageView image = layout.findViewById(R.id.image);
        image.setImageResource(images[position]);
        ImageView logo = layout.findViewById(R.id.ferry_logo);
        logo.setImageResource(ferryLogos[position]);
        TextView name = layout.findViewById(R.id.ferry_name);
        name.setText(ferryNames[position]);
        TextView routes = layout.findViewById(R.id.routes);
        routes.setText(ferryRoutes[position]);
        return layout;
    }
}
