package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class DonSakKohTaoTable extends FerryContract {

    private static String[][] SCHEDULE = {

            {"Seatran", "11:00", "15:00", "4h", "700 B"},
            {"Seatran", "14:30", "18:30", "4h", "700 B"},

    };

    public DonSakKohTaoTable() {
        super("Don_Sak", "Koh_Tao");
    }


    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i < SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_DEPARTURE, SCHEDULE[i][1]);
            cv.put(this.COLUMN_ARRIVAL, SCHEDULE[i][2]);
            cv.put(this.COLUMN_TRAVEL_TIME, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][4]);

            db.insert(this.getTableName(), null, cv);
        }
    }
}
