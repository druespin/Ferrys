package com.akostikov.datab;

import java.util.List;

public class ListItem {

    int boatLogo;
    String boat, depart, arrive, time, price;

    public ListItem(int boatLogo, String boat, String depart, String arrive, String time, String price)  {

        this.boatLogo = boatLogo;
        this.boat = boat;
        this.depart = depart;
        this.arrive = arrive;
        this.time = time;
        this.price = price;
    }

    public int getBoatLogo() {
        return boatLogo;
    }

    public String getBoat() {
        return boat;
    }

    public String getDepart() {
        return depart;
    }

    public String getArrive() {
        return arrive;
    }

    public String getTime() {
        return time;
    }

    public String getPrice() {
        return price;
    }
}
