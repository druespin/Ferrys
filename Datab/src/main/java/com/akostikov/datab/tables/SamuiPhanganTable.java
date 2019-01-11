package com.akostikov.datab.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.datab.data.FerryContract;

public class SamuiPhanganTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Lomprayah", "8:00", "Pralan Pier", "8:20", "Thong Sala Pier", "300 B"},
            {"Seatran", "8:00", "Bangrak Pier", "8:30", "Thong Sala Pier", "300 B"},
            {"Raja", "9:00", "Lipa Noi Pier", "10:30", "Thong Sala Pier", "150 B"},
            {"Haadrin Queen", "10:30", "Big Buddha Pier", "11:20", "Haadrin Pier", "200 B"},
            {"Lomprayah", "11:15", "Nathon Pier", "11:45", "Thong Sala Pier", "300 B"},
            {"Songserm", "11:30", "Nathon Pier", "12:15", "Thong Sala Pier", "200 B" },
            {"Raja", "12:00", "Lipa Noi Pier", "13:30", "Thong Sala Pier", "150 B"  },
            {"Lomprayah", "12:30", "Pralan Pier", "12:50", "Thong Sala Pier", "300 B" },
            {"Seatran", "13:00", "Bangrak Pier", "13:30", "Thong Sala Pier", "300 B"},
            {"Haadrin Queen", "13:00", "Big Buddha Pier", "13:50", "Haadrin Pier", "200 B"},
            {"Lomprayah", "13:30", "Nathon Pier", "14:00", "Thong Sala Pier", "300 B" },
            { "Raja", "14:00", "Lipa Noi Pier", "15:30", "Thong Sala Pier", "150 B" },
            {"Haadrin Queen", "16:00", "Big Buddha Pier", "16:50", "Haadrin Pier", "200 B"},
            {"Seatran", "16:30", "Bangrak Pier", "17:00", "Thong Sala Pier", "300 B"},
            {"Lomprayah", "17:30", "Nathon Pier", "18:00", "Thong Sala Pier", "300 B" },
            {"Songserm", "17:30", "Nathon Pier", "18:15", "Thong Sala Pier", "200 B" },
            { "Raja", "18:00", "Lipa Noi Pier", "19:30", "Thong Sala Pier", "150 B" },
            {"Haadrin Queen", "18:30", "Big Buddha Pier", "19:20", "Haadrin Pier", "200 B"},
    };


    public SamuiPhanganTable() {
        super("Samui", "Phangan");
    }

    public void populateTable(SQLiteDatabase db)    {

        ContentValues cv = new ContentValues();

        for (int i = 0; i< SCHEDULE.length; i++) {
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
