package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.data.FerryContract;

public class DonSakPhanganTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "6:00", "Raja Ferry Pier", "8:30", "Thong Sala Pier", "210 THB"},
            {"Raja", "8:00", "Raja Ferry Pier", "10:30", "Thong Sala Pier", "210 THB"},
            {"Raja", "10:00", "Raja Ferry Pier", "12:30", "Thong Sala Pier", "210 THB"},
            {"Seatran", "11:00", "Seatran Ferry Pier", "13:30", "Thong Sala Pier", "450 THB"},
            {"Raja", "14:00", "Raja Ferry Pier", "16:30", "Thong Sala Pier", "210 THB"},
            {"Seatran", "14:30", "Seatran Ferry Pier", "17:00", "Thong Sala Pier", "450 THB"},
            {"Raja", "16:00", "Raja Ferry Pier", "18:30", "Thong Sala Pier", "210 THB"},
            {"Raja", "18:00", "Raja Ferry Pier", "20:30", "Thong Sala Pier", "210 THB" }
    };

    public DonSakPhanganTable() {
        super("Don_Sak", "Phangan");
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

            db.insert(this.getTableName(), null, cv);
        }
    }
}
