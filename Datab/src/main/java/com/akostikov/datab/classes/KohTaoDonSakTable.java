package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class KohTaoDonSakTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Seatran", "6:30", "10:30", "4h", "700 B"},
            {"Seatran", "9:00", "13:00", "4h", "700 B"},
    };

    public KohTaoDonSakTable() {
        super("Koh_Tao", "Don_Sak");
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
