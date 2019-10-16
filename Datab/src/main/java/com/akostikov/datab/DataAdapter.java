package com.akostikov.datab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<ListItem> items;

    public DataAdapter(Context context, ArrayList<ListItem> items)  {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = inflater.inflate(R.layout.list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        ListItem item = items.get(position);

        viewHolder.boatLogo.setImageResource(item.getBoatLogo());
        viewHolder.timeDepart.setText(item.getTimeDepart());
        viewHolder.timeArrive.setText(item.getTimeArrive());
        viewHolder.pierDepart.setText(item.getPierDepart());
        viewHolder.pierArrive.setText(item.getPierArrive());
        viewHolder.price.setText(item.getPrice());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView boatLogo;
        final TextView timeDepart, timeArrive, pierDepart, pierArrive, price;

        ViewHolder(View view)   {
            super(view);

            boatLogo = view.findViewById(R.id.boatLogo);
            timeDepart = view.findViewById(R.id.timeDepart);
            timeArrive = view.findViewById(R.id.timeArrive);
            pierDepart =  view.findViewById(R.id.pierDepart);
            pierArrive = view.findViewById(R.id.pierArrive);
            price = view.findViewById(R.id.price);
        }
    }
}
