package com.akostikov.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private ArrayList<ListItem> items;

    public DataAdapter(ArrayList<ListItem> items)  {
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {

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
        return items.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        final ImageView boatLogo;
        final TextView timeDepart, timeArrive, pierDepart, pierArrive, price;

        MyViewHolder(View view)   {
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
