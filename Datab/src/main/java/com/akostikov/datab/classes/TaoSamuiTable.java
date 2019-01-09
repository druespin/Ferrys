package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class TaoSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "6:00", "7:50", "1h 50min", "700 B"},
            {"Seatran", "6:30", "8:30", "2h", "600 B"},
            {"Lomprayah", "9:00", "11:00", "2h", "600 B"},
            {"Lomprayah", "9:30", "11:20", "1h 50min", "600 B"},
            {"Songserm", "10:00", "13:15", "3h 15min", "500 B" },
            {"Seatran", "15:00", "17:30", "2h 30min", "600 B"},
            {"Lomprayah", "15:00", "16:40", "1h 40min", "600 B"},
    };


    public TaoSamuiTable() {
        super("Koh_Tao", "Samui");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i< SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_DEPARTURE, SCHEDULE[i][1]);
            cv.put(this.COLUMN_ARRIVAL, SCHEDULE[i][2]);
            cv.put(this.COLUMN_PIER, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][4]);

            db.insert(this.getTableName(),null, cv);
        }
    }
}
