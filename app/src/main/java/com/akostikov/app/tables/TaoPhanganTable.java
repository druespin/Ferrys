package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.data.FerryContract;

public class TaoPhanganTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "6:00", "Mae Haad Pier", "7:10", "Thong Sala Pier", "600 THB"},
            {"Seatran", "6:30", "Mae Haad Pier", "8:00", "Thong Sala Pier", "450 THB"},
            {"Seatran", "9:00", "Mae Haad Pier", "10:30", "Thong Sala Pier", "450 THB"},
            {"Lomprayah", "9:30", "Mae Haad Pier", "10:45", "Thong Sala Pier", "500 THB"},
            {"Songserm", "10:00", "Mae Haad Pier", "11:30", "Thong Sala Pier", "350 THB" },
            {"Seatran", "15:00", "Mae Haad Pier", "16:30", "Thong Sala Pier", "450 THB"},
            {"Lomprayah", "15:00", "Mae Haad Pier", "16:10", "Thong Sala Pier", "500 THB"},
    };

    public TaoPhanganTable() {
        super("Koh_Tao", "Phangan");
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
