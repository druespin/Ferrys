package com.akostikov.datab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListItemAdapter extends ArrayAdapter<ListItem> {

    private LayoutInflater inflater;
    private int layout;
    private ArrayList<ListItem> items;

    public ListItemAdapter(Context context, int resource, ArrayList<ListItem> items)  {
        super(context, resource, items);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.items = items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        ImageView boatLogo = view.findViewById(R.id.boatLogo);
        TextView boat = view.findViewById(R.id.boat);
        TextView depart = view.findViewById(R.id.depart);
        TextView arrive = view.findViewById(R.id.arrive);
        TextView time = view.findViewById(R.id.time);
        TextView price = view.findViewById(R.id.price);

        ListItem item = items.get(position);

        //boatLogo.setImageResource(item.getBoatLogo());
        boat.setText(item.getBoat());
        depart.setText(item.getDepart());
        arrive.setText(item.getArrive());
        time.setText(item.getTime());
        price.setText(item.getPrice());

        return view;
    }
}
