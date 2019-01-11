package com.akostikov.datab.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class DonSakKohTaoTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Seatran", "11:00", "Seatran Ferry Pier", "15:00", "Mae Haad Pier", "700 B"},
            {"Seatran", "14:30", "Seatran Ferry Pier", "18:30", "Mae Haad Pier", "700 B"},

    };

    public DonSakKohTaoTable() {
        super("Don_Sak", "Koh_Tao");
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
