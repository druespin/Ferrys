package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.sqlite.FerryContract;

public class PhanganTaoTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "08:30", "Thong Sala Pier", "09:30", "Mae Haad Pier", "500 THB"},
            {"Seatran", "08:30", "Thong Sala Pier", "10:00", "Mae Haad Pier", "450 THB"},
            {"Songserm", "12:30", "Thong Sala Pier", "14:00", "Mae Haad Pier", "350 THB" },
            {"Lomprayah", "13:00", "Thong Sala Pier", "14:15", "Mae Haad Pier", "500 THB"},
            {"Seatran", "13:30", "Thong Sala Pier", "15:00", "Mae Haad Pier", "450 THB"},
            {"Seatran", "17:00", "Thong Sala Pier", "18:30", "Mae Haad Pier", "450 THB"},
            {"Lomprayah", "18:15", "Thong Sala Pier", "19:15", "Mae Haad Pier", "500 THB"},
    };

    public PhanganTaoTable() {
        super("Phangan", "Koh_Tao");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i < SCHEDULE.length; i++) {
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
