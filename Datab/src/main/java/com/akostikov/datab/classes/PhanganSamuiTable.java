package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class PhanganSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "7:00", "8:30", "1h 30min", "150 B"},
            {"Songserm", "7:00", "7:45", "45min", "200 B" },
            {"Lomprayah", "7:20", "7:50", "30min", "300 B"},
            {"Seatran", "8:00", "8:30", "30min", "300 B"},
            {"Haadrin Queen", "9:30", "10:20", "50min", "200 B"},
            {"Seatran", "10:30", "11:00", "30min", "300 B"},
            {"Lomprayah", "11:00", "11:20", "20min", "300 B"},
            {"Haadrin Queen", "11:40", "12:30", "50min", "200 B"},
            {"Lomprayah", "12:00", "12:30", "30min", "300 B"},
            {"Raja", "12:00", "13:30", "1h 30min", "150 B"  },
            {"Songserm", "12:30", "13:45", "1h 15min", "200 B" },
            { "Raja", "14:00", "15:30", "1h 30min", "150 B" },
            {"Lomprayah", "14:30", "15:00", "30min", "300 B" },
            {"Haadrin Queen", "14:30", "15:20", "50min", "200 B"},
            {"Lomprayah", "16:20", "16:40", "20min", "300 B" },
            {"Seatran", "16:30", "17:00", "30min", "300 B"},
            { "Raja", "17:30", "19:00", "1h 30min", "150 B" },
            {"Haadrin Queen", "17:30", "18:20", "50min", "200 B"},
    };


    public PhanganSamuiTable() {
        super("Phangan", "Samui");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i< SCHEDULE.length; i++) {
            cv.put(this.COLUMN_BOAT, SCHEDULE[i][0]);
            cv.put(this.COLUMN_DEPARTURE, SCHEDULE[i][1]);
            cv.put(this.COLUMN_ARRIVAL, SCHEDULE[i][2]);
            cv.put(this.COLUMN_PIER, SCHEDULE[i][3]);
            cv.put(this.COLUMN_PRICE, SCHEDULE[i][4]);

            db.insert(this.getTableName(),null, cv);
        }
    }
}
