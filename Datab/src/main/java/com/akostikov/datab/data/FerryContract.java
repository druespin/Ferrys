package com.akostikov.datab.data;

import android.provider.BaseColumns;

public class FerryContract implements BaseColumns  {

    private String tableName;

    public FerryContract(String departure, String arrival) {
        this.tableName = departure + "_" + arrival;
    }

    protected final String COLUMN_BOAT = "Boat";
    protected final String COLUMN_DEPARTURE = "Departure";
    protected final String COLUMN_ARRIVAL = "Arrival";
    protected final String COLUMN_TRAVEL_TIME = "Travel_Time";
    protected final String COLUMN_PRICE = "Price";


    public String getTableName() {
        return tableName;
    }

    public String[] getColumns()    {

        return new String[]{this.COLUMN_BOAT,
                            this.COLUMN_DEPARTURE,
                            this.COLUMN_ARRIVAL,
                            this.COLUMN_TRAVEL_TIME,
                            this.COLUMN_PRICE};
    }

    public String createTable() {

        return "CREATE TABLE " + this.getTableName() + "("
                + this._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + this.COLUMN_BOAT + " TEXT, "
                + this.COLUMN_DEPARTURE + " TEXT, "
                + this.COLUMN_ARRIVAL + " TEXT, "
                + this.COLUMN_TRAVEL_TIME + " TEXT, "
                + this.COLUMN_PRICE + " TEXT);";
    }
}
