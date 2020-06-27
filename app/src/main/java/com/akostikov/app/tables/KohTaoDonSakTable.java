package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.sqlite.FerryContract;

public class KohTaoDonSakTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Seatran", "06:30", "Mae Haad Pier", "10:30", "Seatran Ferry Pier", "700 THB"},
            {"Seatran", "09:00", "Mae Haad Pier", "13:00", "Seatran Ferry Pier", "700 THB"},
    };

    public KohTaoDonSakTable() {
        super("Koh_Tao", "Don_Sak");
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
