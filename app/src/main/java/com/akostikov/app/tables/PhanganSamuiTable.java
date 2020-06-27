package com.akostikov.app.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.akostikov.app.sqlite.FerryContract;

public class PhanganSamuiTable extends FerryContract {

    private static String[][] SCHEDULE = {
            {"Raja", "07:00", "Thong Sala Pier", "08:30", "Lipa Noi Pier", "150 THB"},
            {"Songserm", "07:00", "Thong Sala Pier", "07:45", "Nathon Pier", "200 THB" },
            {"Lomprayah", "07:20", "Thong Sala Pier", "07:50", "Nathon Pier", "300 THB"},
            {"Seatran", "08:00", "Thong Sala Pier", "08:30", "Bangrak Pier", "300 THB"},
            {"Haadrin Queen", "09:30", "Haadrin Pier", "10:20", "Big Buddha Pier", "200 THB"},
            {"Seatran", "10:30", "Thong Sala Pier", "11:00", "Bangrak Pier", "300 THB"},
            {"Lomprayah", "11:00", "Thong Sala Pier", "11:20", "Pralan Pier", "300 THB"},
            {"Haadrin Queen", "11:40", "Haadrin Pier", "12:30", "Big Buddha Pier", "200 THB"},
            {"Lomprayah", "12:00", "Thong Sala Pier", "12:30", "Nathon Pier", "300 THB"},
            {"Raja", "12:00", "Thong Sala Pier", "13:30", "Lipa Noi Pier", "150 THB"  },
            {"Songserm", "12:30", "Thong Sala Pier", "13:45", "Nathon Pier", "200 THB" },
            { "Raja", "14:00", "Thong Sala Pier", "15:30", "Lipa Noi Pier", "150 THB" },
            {"Lomprayah", "14:30", "Thong Sala Pier", "15:00", "Nathon Pier", "300 THB" },
            {"Haadrin Queen", "14:30", "Haadrin Pier", "15:20", "Big Buddha Pier", "200 THB"},
            {"Lomprayah", "16:20", "Thong Sala Pier", "16:40", "Pralan Pier", "300 THB" },
            {"Seatran", "16:30", "Thong Sala Pier", "17:00", "Bangrak Pier", "300 THB"},
            { "Raja", "17:30", "Thong Sala Pier", "19:00", "Lipa Noi Pier", "150 THB" },
            {"Haadrin Queen", "17:30", "Haadrin Pier", "18:20", "Big Buddha Pier", "200 THB"},
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
