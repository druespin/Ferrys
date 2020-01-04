package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.data.FerryContract;

public class TaoSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "06:00", "Mae Haad Pier", "07:50", "Nathon Pier", "700 THB"},
            {"Seatran", "06:30", "Mae Haad Pier", "08:30", "Bangrak Pier", "600 THB"},
            {"Seatran", "09:00", "Mae Haad Pier", "11:00", "Bangrak Pier", "600 THB"},
            {"Lomprayah", "09:30", "Mae Haad Pier", "11:20", "Pralan Pier", "600 THB"},
            {"Songserm", "10:00", "Mae Haad Pier", "13:15", "Nathon Pier", "500 THB" },
            {"Seatran", "15:00", "Mae Haad Pier", "17:30", "Bangrak Pier", "600 THB"},
            {"Lomprayah", "15:00", "Mae Haad Pier", "16:40", "Pralan Pier", "600 THB"},
    };


    public TaoSamuiTable() {
        super("Koh_Tao", "Samui");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i< SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_TIME_DEPART, SCHEDULE[i][1]);
            cv.put(this.COLUMN_PIER_DEPART, SCHEDULE[i][2]);
            cv.put(this.COLUMN_TIME_ARRIVE, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PIER_ARRIVE, SCHEDULE[i][4]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][5]);

            db.insert(this.getTableName(),null, cv);
        }
    }
}
