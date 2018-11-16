package com.akostikov.datab.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.akostikov.datab.data.FerryContract;

public class FerryDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ferrytime.db";
    private static final int DATABASE_VERSION = 1;

    public FerryDBHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_DONSAK_SAMUI = new FerryContract("Donsak", "Samui").createTable();

        db.execSQL(SQL_CREATE_DONSAK_SAMUI);

        String SQL_CREATE_SAMUI_DONSAK = new FerryContract("Samui", "Donsak").createTable();

        db.execSQL(SQL_CREATE_SAMUI_DONSAK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
