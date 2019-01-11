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
        TextView timeDepart = convertView.findViewById(R.id.timeDepart);
        TextView timeArrive = convertView.findViewById(R.id.timeArrive);
        TextView pierDepart = convertView.findViewById(R.id.pierDepart);
        TextView pierArrive = convertView.findViewById(R.id.pierArrive);
        TextView price = convertView.findViewById(R.id.price);

        ListItem item = items.get(position);

        boatLogo.setImageResource(item.getBoatLogo());
        timeDepart.setText(item.getTimeDepart());
        timeArrive.setText(item.getTimeArrive());
        pierDepart.setText(item.getPierDepart());
        pierArrive.setText(item.getPierArrive());
        price.setText("Price : " + item.getPrice());

        return convertView;
    }

    private class ViewHolder {
        final ImageView boatLogo;
        final TextView timeDepart, timeArrive, pierDepart, pierArrive, price;

        ViewHolder(View view)   {

            boatLogo = view.findViewById(R.id.boatLogo);
            timeDepart = view.findViewById(R.id.timeDepart);
            timeArrive = view.findViewById(R.id.timeArrive);
            pierDepart =  view.findViewById(R.id.pierDepart);
            pierArrive = view.findViewById(R.id.pierArrive);
            price = view.findViewById(R.id.price);
        }
    }
}
