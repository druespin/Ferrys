package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class TaoSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "6:00", "Mae Haad Pier", "7:50", "Nathon Pier", "700 B"},
            {"Seatran", "6:30", "Mae Haad Pier", "8:30", "Bangrak Pier", "600 B"},
            {"Seatran", "9:00", "Mae Haad Pier", "11:00", "Bangrak Pier", "600 B"},
            {"Lomprayah", "9:30", "Mae Haad Pier", "11:20", "Pralan Pier", "600 B"},
            {"Songserm", "10:00", "Mae Haad Pier", "13:15", "Nathon Pier", "500 B" },
            {"Seatran", "15:00", "Mae Haad Pier", "17:30", "Bangrak Pier", "600 B"},
            {"Lomprayah", "15:00", "Mae Haad Pier", "16:40", "Pralan Pier", "600 B"},
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
