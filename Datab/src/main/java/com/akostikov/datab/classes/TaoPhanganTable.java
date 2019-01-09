package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class TaoPhanganTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "6:00", "7:10", "1h 10min", "600 B"},
            {"Seatran", "6:30", "8:00", "1h 30min", "450 B"},
            {"Seatran", "9:00", "10:30", "1h 30min", "450 B"},
            {"Lomprayah", "9:30", "10:45", "1h 15min", "500 B"},
            {"Songserm", "10:00", "11:30", "1h 30min", "350 B" },
            {"Seatran", "15:00", "16:30", "1h 30min", "450 B"},
            {"Lomprayah", "15:00", "16:10", "1h 10min", "500 B"},
    };

    public TaoPhanganTable() {
        super("Koh_Tao", "Phangan");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i < SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_DEPARTURE, SCHEDULE[i][1]);
            cv.put(this.COLUMN_ARRIVAL, SCHEDULE[i][2]);
            cv.put(this.COLUMN_PIER, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][4]);

            db.insert(this.getTableName(),null, cv);
        }
    }
}
