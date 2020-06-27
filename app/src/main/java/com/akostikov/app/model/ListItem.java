package com.akostikov.app.model;


public class ListItem {

    private int boatLogo;
    private String pierDepart, pierArrive, timeDepart, timeArrive, price;

    public ListItem(int boatLogo, String timeDepart, String pierDepart, String timeArrive,
                    String pierArrive, String price)  {

        this.boatLogo = boatLogo;
        this.timeDepart = timeDepart;
        this.timeArrive = timeArrive;
        this.pierArrive = pierArrive;
        this.pierDepart = pierDepart;
        this.price = price;
    }

    public int getBoatLogo() {
        return boatLogo;
    }
    public String getTimeDepart() { return timeDepart; }
    public String getPierDepart() {return pierDepart; }
    public String getTimeArrive() {
        return timeArrive;
    }
    public String getPierArrive() {
        return pierArrive;
    }
    public String getPrice() {
        return price;
    }
}
