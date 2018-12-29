package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class SamuiTaoTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Lomprayah", "8:00", "9:30", "1h 30min", "600 B"},
            {"Seatran", "8:00", "10:00", "2h", "600 B"},
            {"Lomprayah", "11:15", "14:15", "3h", "600 B"},
            {"Songserm", "11:30", "14:00", "2h 30min", "500 B" },
            {"Lomprayah", "12:30", "14:15", "1h 45min", "600 B"},
            {"Seatran", "13:00", "15:00", "2h", "600 B"},
            {"Seatran", "16:30", "18:30", "2h", "600 B"},
            {"Lomprayah", "17:30", "19:15", "1h 45min", "700 B"},
    };


    public SamuiTaoTable() {
        super("Samui", "Koh_Tao");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i< SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_DEPARTURE, SCHEDULE[i][1]);
            cv.put(this.COLUMN_ARRIVAL, SCHEDULE[i][2]);
            cv.put(this.COLUMN_TRAVEL_TIME, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][4]);

            db.insert(this.getTableName(),null, cv);
        }
    }
}
