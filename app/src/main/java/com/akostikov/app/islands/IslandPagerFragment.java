package com.akostikov.app.islands;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.akostikov.app.R;

public class IslandPagerFragment extends Fragment {

    private String[] islands = new String[] {
            "Ko Samui",
            "Ko Phangan",
            "Ko Tao"
    };
    private int[] islandImages = new int[] {
            R.drawable.samui_map,
            R.drawable.phangan_map,
            R.drawable.tao_map,
    };
    private int[] islandDesc = new int[] {
            R.string.samui_info,
            R.string.phangan_info,
            R.string.tao_info
    };
    private int position;

    IslandPagerFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_island_pager, container, false);
        ImageView image = layout.findViewById(R.id.island_image);
        image.setImageResource(islandImages[position]);

        TextView island = layout.findViewById(R.id.island_name);
        island.setText(islands[position]);
        TextView info = layout.findViewById(R.id.island_text);
        info.setText(islandDesc[position]);
//        TextView routes = layout.findViewById(R.id.routes);
//        routes.setText(ferryRoutes[position]);
        return layout;
    }
}
