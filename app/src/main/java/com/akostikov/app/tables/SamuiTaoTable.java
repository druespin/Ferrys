package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.sqlite.FerryContract;

public class SamuiTaoTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "08:00", "Pralan Pier", "09:30", "Mae Haad Pier", "600 THB"},
            {"Seatran", "08:00", "Bangrak Pier", "10:00", "Mae Haad Pier", "600 THB"},
            {"Lomprayah", "11:15", "Nathon Pier", "14:15", "Mae Haad Pier", "600 THB"},
            {"Songserm", "11:30", "Nathon Pier", "14:00", "Mae Haad Pier", "500 THB" },
            {"Lomprayah", "12:30","Pralan Pier",  "14:15", "Mae Haad Pier", "600 THB"},
            {"Seatran", "13:00", "Bangrak Pier", "15:00", "Mae Haad Pier", "600 THB"},
            {"Seatran", "16:30", "Bangrak Pier", "18:30", "Mae Haad Pier", "600 THB"},
            {"Lomprayah", "17:30", "Nathon Pier", "19:15", "Mae Haad Pier", "700 THB"},
    };


    public SamuiTaoTable() {
        super("Samui", "Koh_Tao");
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
