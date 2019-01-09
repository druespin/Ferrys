package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class DonSakPhanganTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "6:00", "8:30", "2h 30min", "210 B"},
            {"Raja", "8:00", "10:30", "2h 30min", "210 B"},
            {"Raja", "10:00", "12:30", "2h 30min", "210 B"},
            {"Seatran", "11:00", "13:30", "2h 30min", "450 B"},
            {"Raja", "14:00", "16:30", "2h 30min", "210 B"},
            {"Seatran", "14:30", "17:00", "2h 30min", "450 B"},
            {"Raja", "16:00", "18:30", "2h 30min", "210 B"},
            {"Raja", "18:00", "20:30", "2h 30min", "210 B" }
    };

    public DonSakPhanganTable() {
        super("Don_Sak", "Phangan");
    }


    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i < SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_DEPARTURE, SCHEDULE[i][1]);
            cv.put(this.COLUMN_ARRIVAL, SCHEDULE[i][2]);
            cv.put(this.COLUMN_PIER, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][4]);

            db.insert(this.getTableName(), null, cv);
        }
    }
}
