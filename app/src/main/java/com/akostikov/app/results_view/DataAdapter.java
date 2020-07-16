package com.akostikov.app.results_view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akostikov.app.R;
import com.akostikov.app.database.RoomItem;
import com.akostikov.app.model.Item;

import java.util.ArrayList;
import java.util.List;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private List<RoomItem> items;

    DataAdapter(List<RoomItem> items)  {
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
        Item item = items.get(position);

        viewHolder.boatLogo.setImageResource(getBoatLogo(item.getBoat()));
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

    static class MyViewHolder extends RecyclerView.ViewHolder {
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

    private int getBoatLogo(String boat) {
        switch (boat) {
            default: return 404;
            case "Raja": return R.drawable.raja;
            case "Lomprayah": return R.drawable.lomprayah;
            case "Seatran": return R.drawable.seatran;
            case "Songserm": return R.drawable.songserm;
            case "Haadrin Queen": return R.drawable.haadrin_queen;
        }
    }
}
