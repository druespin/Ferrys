package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.akostikov.datab.data.FerryContract;


public class DonSakSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "7:00", "8:30", "1h 30min", "140 B"},
            {"Raja", "8:00", "9:30", "1h 30min", "140 B"},
            {"Raja", "9:00", "10:30", "1h 30min", "140 B"},
            {"Raja", "10:00", "11:30", "1h 30min", "140 B"},
            {"Raja", "11:00", "12:30", "1h 30min", "140 B"},
            {"Seatran", "11:00", "12:30", "1h 30min", "350 B" },
            { "Seatran", "14:30", "16:00", "1h 30min", "350 B" },
            { "Raja", "17:00", "18:30", "1h 30min", "140 B"  },
            { "Raja", "18:00", "19:30", "1h 30min", "140 B" },
            { "Raja", "19:30", "21:00", "1h 30min", "140 B" }
    };


    public DonSakSamuiTable() {
        super("Don_Sak", "Samui");
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
