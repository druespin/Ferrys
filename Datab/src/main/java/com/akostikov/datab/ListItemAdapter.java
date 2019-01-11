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

        ViewHolder viewHolder;

        if (convertView == null) {

            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else    {
                viewHolder = (ViewHolder) convertView.getTag();
        }

        ImageView boatLogo = convertView.findViewById(R.id.boatLogo);
        TextView pier = convertView.findViewById(R.id.pier);
        TextView depart = convertView.findViewById(R.id.depart);
        TextView arrive = convertView.findViewById(R.id.arrive);
        TextView price = convertView.findViewById(R.id.price);

        ListItem item = items.get(position);

        boatLogo.setImageResource(item.getBoatLogo());
        pier.setText(item.getPier());
        depart.setText(item.getDepart());
        arrive.setText(item.getArrive());
        price.setText(item.getPrice());

        return convertView;
    }

    private class ViewHolder {
        final ImageView boatLogo;
        final TextView pier, depart, arrive, price;

        ViewHolder(View view)   {

            boatLogo = view.findViewById(R.id.boatLogo);
            pier =  view.findViewById(R.id.pier);
            depart = view.findViewById(R.id.depart);
            arrive = view.findViewById(R.id.arrive);
            price = view.findViewById(R.id.price);

        }
    }
}
