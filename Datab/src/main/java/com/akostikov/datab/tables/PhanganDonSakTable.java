package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class PhanganDonSakTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "5:00", "Thong Sala Pier", "7:30", "Raja Ferry Pier", "210 B"},
            {"Raja", "7:00", "Thong Sala Pier", "9:30", "Raja Ferry Pier", "210 B"},
            {"Seatran", "8:00", "Thong Sala Pier", "10:30", "Seatran Ferry Pier", "450 B" },
            {"Seatran", "10:30", "Thong Sala Pier", "13:00", "Seatran Ferry Pier", "450 B" },
            {"Raja", "11:00", "Thong Sala Pier", "13:30", "Raja Ferry Pier", "210 B"},
            {"Raja", "13:00", "Thong Sala Pier", "15:30", "Raja Ferry Pier", "210 B"},
            {"Raja", "17:00", "Thong Sala Pier", "19:30", "Raja Ferry Pier", "210 B"}
    };


    public PhanganDonSakTable() {
        super("Phangan", "Don_Sak");
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
