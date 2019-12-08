package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.data.FerryContract;

public class PhanganSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "7:00", "Thong Sala Pier", "8:30", "Lipa Noi Pier", "150 B"},
            {"Songserm", "7:00", "Thong Sala Pier", "7:45", "Nathon Pier", "200 B" },
            {"Lomprayah", "7:20", "Thong Sala Pier", "7:50", "Nathon Pier", "300 B"},
            {"Seatran", "8:00", "Thong Sala Pier", "8:30", "Bangrak Pier", "300 B"},
            {"Haadrin Queen", "9:30", "Haadrin Pier", "10:20", "Big Buddha Pier", "200 B"},
            {"Seatran", "10:30", "Thong Sala Pier", "11:00", "Bangrak Pier", "300 B"},
            {"Lomprayah", "11:00", "Thong Sala Pier", "11:20", "Pralan Pier", "300 B"},
            {"Haadrin Queen", "11:40", "Haadrin Pier", "12:30", "Big Buddha Pier", "200 B"},
            {"Lomprayah", "12:00", "Thong Sala Pier", "12:30", "Nathon Pier", "300 B"},
            {"Raja", "12:00", "Thong Sala Pier", "13:30", "Lipa Noi Pier", "150 B"  },
            {"Songserm", "12:30", "Thong Sala Pier", "13:45", "Nathon Pier", "200 B" },
            { "Raja", "14:00", "Thong Sala Pier", "15:30", "Lipa Noi Pier", "150 B" },
            {"Lomprayah", "14:30", "Thong Sala Pier", "15:00", "Nathon Pier", "300 B" },
            {"Haadrin Queen", "14:30", "Haadrin Pier", "15:20", "Big Buddha Pier", "200 B"},
            {"Lomprayah", "16:20", "Thong Sala Pier", "16:40", "Pralan Pier", "300 B" },
            {"Seatran", "16:30", "Thong Sala Pier", "17:00", "Bangrak Pier", "300 B"},
            { "Raja", "17:30", "Thong Sala Pier", "19:00", "Lipa Noi Pier", "150 B" },
            {"Haadrin Queen", "17:30", "Haadrin Pier", "18:20", "Big Buddha Pier", "200 B"},
    };


    public PhanganSamuiTable() {
        super("Phangan", "Samui");
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
