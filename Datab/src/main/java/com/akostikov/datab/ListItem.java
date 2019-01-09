package com.akostikov.datab;

import java.util.List;

public class ListItem {

    int boatLogo;
    String pier, depart, arrive, price;

    public ListItem(int boatLogo, String pier, String depart, String arrive, String price)  {

        this.boatLogo = boatLogo;
       // this.boat = boat;
        this.pier = pier;
        this.depart = depart;
        this.arrive = arrive;
        this.price = price;
    }

    public int getBoatLogo() {
        return boatLogo;
    }

    // public String getBoat() {return boat; }

    public String getDepart() {
        return depart;
    }

    public String getArrive() {
        return arrive;
    }

    public String getPier() {
        return pier;
    }

    public String getPrice() {
        return price;
    }
}
