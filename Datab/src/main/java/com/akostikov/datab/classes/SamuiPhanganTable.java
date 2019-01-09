package com.akostikov.datab.classes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class SamuiPhanganTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Lomprayah", "8:00", "8:20", "20min", "300 B"},
            {"Seatran", "8:00", "8:30", "30min", "300 B"},
            {"Raja", "9:00", "10:30", "1h 30min", "150 B"},
            {"Haadrin Queen", "10:30", "11:20", "50min", "200 B"},
            {"Lomprayah", "11:15", "11:45", "30min", "300 B"},
            {"Songserm", "11:30", "12:15", "45min", "200 B" },
            {"Raja", "12:00", "13:30", "1h 30min", "150 B"  },
            {"Lomprayah", "12:30", "12:50", "20min", "300 B" },
            {"Seatran", "13:00", "13:30", "30min", "300 B"},
            {"Haadrin Queen", "13:00", "13:50", "50min", "200 B"},
            {"Lomprayah", "13:30", "14:00", "30min", "300 B" },
            { "Raja", "14:00", "15:30", "1h 30min", "150 B" },
            {"Haadrin Queen", "16:00", "16:50", "50min", "200 B"},
            {"Seatran", "16:30", "17:00", "30min", "300 B"},
            {"Lomprayah", "17:30", "18:00", "30min", "300 B" },
            {"Songserm", "17:30", "18:15", "45min", "200 B" },
            { "Raja", "18:00", "19:30", "1h 30min", "150 B" },
            {"Haadrin Queen", "18:30", "19:20", "50min", "200 B"},
    };


    public SamuiPhanganTable() {
        super("Samui", "Phangan");
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
