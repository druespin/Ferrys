package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class PhanganDonSakTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "5:00", "7:30", "2h 30min", "210 B"},
            {"Raja", "7:00", "9:30", "2h 30min", "210 B"},
            {"Seatran", "8:00", "10:30", "2h 30min", "450 B" },
            {"Seatran", "10:30", "13:00", "2h 30min", "450 B" },
            {"Raja", "11:00", "13:30", "2h 30min", "210 B"},
            {"Raja", "13:00", "15:30", "2h 30min", "210 B"},
            {"Raja", "17:00", "19:30", "2h 30min", "210 B"}
    };


    public PhanganDonSakTable() {
        super("Phangan", "Don_Sak");
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
