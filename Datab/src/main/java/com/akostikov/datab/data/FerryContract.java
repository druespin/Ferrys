package com.akostikov.datab.data;

import android.provider.BaseColumns;

public class FerryContract implements BaseColumns  {

    private String tableName;

    public FerryContract(String departure, String arrival) {
        this.tableName = departure + "_" + arrival;
    }

    protected final String COLUMN_BOAT = "Boat";
    protected final String COLUMN_TIME_DEPART = "Departure";
    protected final String COLUMN_PIER_DEPART = "Pier_Depart";
    protected final String COLUMN_TIME_ARRIVE = "Arrival";
    protected final String COLUMN_PIER_ARRIVE = "Pier_Arrive";
    protected final String COLUMN_PRICE = "Price";


    public String getTableName() {
        return tableName;
    }

    public String[] getColumns()    {

        return new String[]{this.COLUMN_BOAT,
                            this.COLUMN_TIME_DEPART,
                            this.COLUMN_PIER_DEPART,
                            this.COLUMN_TIME_ARRIVE,
                            this.COLUMN_PIER_ARRIVE,
                            this.COLUMN_PRICE};
    }

    public String createTable() {

        return "CREATE TABLE " + this.getTableName() + "("
                + this._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + this.COLUMN_BOAT + " TEXT, "
                + this.COLUMN_TIME_DEPART + " TEXT, "
                + this.COLUMN_PIER_DEPART + " TEXT, "
                + this.COLUMN_TIME_ARRIVE + " TEXT, "
                + this.COLUMN_PIER_ARRIVE + " TEXT, "
                + this.COLUMN_PRICE + " TEXT);";
    }
}
