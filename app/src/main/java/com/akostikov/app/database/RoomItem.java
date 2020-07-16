package com.akostikov.app.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.akostikov.app.model.Item;

@Entity
public class RoomItem implements Item {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private String departure;
    private String arrival;
    private String boat;
    private String price;

    @ColumnInfo(name = "time_depart")
    private String timeDepart;

    @ColumnInfo(name = "pier_depart")
    private String pierDepart;

    @ColumnInfo(name = "time_arrive")
    private String timeArrive;

    @ColumnInfo(name = "pier_arrive")
    private String pierArrive;


    public RoomItem(String departure, String arrival,
                    String boat,
                    String timeDepart, String pierDepart,
                    String timeArrive, String pierArrive,
                    String price) {
        this.departure = departure;
        this.arrival = arrival;
        this.boat = boat;
        this.timeDepart = timeDepart;
        this.pierDepart = pierDepart;
        this.timeArrive = timeArrive;
        this.pierArrive = pierArrive;
        this.price = price;
    }

    @Override
    public String getDeparture() {
        return departure;
    }

    @Override
    public String getArrival() {
        return arrival;
    }

    @Override
    public String getBoat() {
        return boat;
    }

    @Override
    public String getTimeDepart() {
        return timeDepart;
    }

    @Override
    public String getPierDepart() {
        return pierDepart;
    }

    @Override
    public String getTimeArrive() {
        return timeArrive;
    }

    @Override
    public String getPierArrive() {
        return pierArrive;
    }

    @Override
    public String getPrice() {
        return price;
    }
}
