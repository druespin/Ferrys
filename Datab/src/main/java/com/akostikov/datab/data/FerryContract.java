package com.akostikov.datab.data;

import android.provider.BaseColumns;

public class FerryContract implements BaseColumns  {

    public final String _ID = BaseColumns._ID;
    public final String COLUMN_BOAT = "Boat";
    public final String COLUMN_DEPARTURE = "Departure";
    public final String COLUMN_ARRIVAL = "Arrival";
    public final String COLUMN_TRAVEL_TIME = "Travel_time";
    public final String COLUMN_PRICE = "Price";

    private String table_name;

    public FerryContract(String dprt, String arrv) {
        this.table_name = dprt + "_to_" + arrv;
    }

    public String getTable_name() {
        return table_name;
    }

    public String[] getColumns()    {

        return new String[]{this.COLUMN_BOAT,
                            this.COLUMN_DEPARTURE,
                            this.COLUMN_ARRIVAL,
                            this.COLUMN_TRAVEL_TIME,
                            this.COLUMN_PRICE};
    }

    String createTable()    {

        return "CREATE TABLE " + this.getTable_name() + "( "
                + this._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + this.COLUMN_BOAT + " TEXT NOT NULL, "
                + this.COLUMN_DEPARTURE + " TEXT NOT NULL, "
                + this.COLUMN_ARRIVAL + " TEXT NOT NULL, "
                + this.COLUMN_TRAVEL_TIME + " TEXT NOT NULL, "
                + this.COLUMN_PRICE + " TEXT NOT NULL)";
    }
}
