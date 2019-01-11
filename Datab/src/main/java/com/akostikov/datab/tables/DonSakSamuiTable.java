package com.akostikov.datab.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.akostikov.datab.data.FerryContract;


public class DonSakSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {
            { "Raja", "7:00", "Raja Ferry Pier", "8:30", "Lipa Noi Pier", "140 B"},
            { "Raja", "8:00", "Raja Ferry Pier", "9:30", "Lipa Noi Pier", "140 B"},
            { "Raja", "9:00", "Raja Ferry Pier", "10:30", "Lipa Noi Pier", "140 B"},
            { "Raja", "10:00", "Raja Ferry Pier", "11:30", "Lipa Noi Pier", "140 B"},
            { "Raja", "11:00", "Raja Ferry Pier", "12:30", "Lipa Noi Pier", "140 B"},
            { "Seatran", "11:00", "Seatran Ferry Pier", "12:30", "Bangrak Pier", "350 B" },
            { "Seatran", "14:30", "Seatran Ferry Pier", "16:00", "Bangrak Pier", "350 B" },
            { "Raja", "17:00", "Raja Ferry Pier", "18:30", "Lipa Noi Pier", "140 B"  },
            { "Raja", "18:00", "Raja Ferry Pier", "19:30", "Lipa Noi Pier", "140 B" },
            { "Raja", "19:30", "Raja Ferry Pier", "21:00", "Lipa Noi Pier", "140 B" }
    };


    public DonSakSamuiTable() {
        super("Don_Sak", "Samui");
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
