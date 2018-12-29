package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class PhanganTaoTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "8:30", "9:30", "1h", "500 B"},
            {"Seatran", "8:30", "10:00", "1h 30min", "450 B"},
            {"Songserm", "12:30", "14:00", "1h 30min", "350 B" },
            {"Lomprayah", "13:00", "14:15", "1h 15min", "500 B"},
            {"Seatran", "13:30", "15:00", "1h 30min", "450 B"},
            {"Seatran", "17:00", "18:30", "1h 30min", "450 B"},
            {"Lomprayah", "18:15", "19:15", "1h", "500 B"},
    };

    public PhanganTaoTable() {
        super("Phangan", "Koh_Tao");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i < SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_DEPARTURE, SCHEDULE[i][1]);
            cv.put(this.COLUMN_ARRIVAL, SCHEDULE[i][2]);
            cv.put(this.COLUMN_TRAVEL_TIME, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][4]);

            db.insert(this.getTableName(),null, cv);
        }
    }
}
