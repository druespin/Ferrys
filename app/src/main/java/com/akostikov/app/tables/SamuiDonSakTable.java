package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.data.FerryContract;

public class SamuiDonSakTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "7:00", "Lipa Noi Pier", "8:30", "Raja Ferry Pier", "140 THB"},
            {"Raja", "8:00", "Lipa Noi Pier", "9:30", "Raja Ferry Pier", "140 THB"},
            {"Raja", "9:00", "Lipa Noi Pier", "10:30", "Raja Ferry Pier", "140 THB"},
            {"Seatran", "9:00", "Bangrak Pier", "10:30", "Seatran Ferry Pier", "350 THB"},
            {"Raja", "10:00", "Lipa Noi Pier", "11:30", "Raja Ferry Pier", "140 THB"},
            {"Raja", "11:00", "Lipa Noi Pier", "12:30", "Raja Ferry Pier", "140 THB"},
            { "Seatran", "11:30", "Bangrak Pier", "13:00", "Seatran Ferry Pier", "350 THB" },
            { "Raja", "17:00", "Lipa Noi Pier", "18:30", "Raja Ferry Pier", "140 THB"  },
            { "Raja", "18:00", "Lipa Noi Pier", "19:30", "Raja Ferry Pier", "140 THB" },
            { "Raja", "19:00", "Lipa Noi Pier", "20:30", "Raja Ferry Pier", "140 THB" }
    };

    public SamuiDonSakTable() {
        super("Samui", "Don_Sak");
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

