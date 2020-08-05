package com.akostikov.app.model;


public class ListItem implements Item {

    private String departure, arrival, boat,
            pierDepart, pierArrive,
            timeDepart, timeArrive,
            price;

    public ListItem(String departure, String arrival,
                    String boat,
                    String timeDepart, String pierDepart,
                    String timeArrive, String pierArrive,
                    String price)  {

        this.departure = departure;
        this.arrival = arrival;
        this.boat = boat;
        this.timeDepart = timeDepart;
        this.timeArrive = timeArrive;
        this.pierArrive = pierArrive;
        this.pierDepart = pierDepart;
        this.price = price;
    }

    public String getDeparture() { return departure; }
    public String getArrival() { return arrival; }
    public String getBoat() { return boat; }
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
