package com.akostikov.datab.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.akostikov.datab.ListItem;
import com.akostikov.datab.R;
import com.akostikov.datab.tables.DonSakKohTaoTable;
import com.akostikov.datab.tables.DonSakPhanganTable;
import com.akostikov.datab.tables.DonSakSamuiTable;
import com.akostikov.datab.tables.KohTaoDonSakTable;
import com.akostikov.datab.tables.PhanganDonSakTable;
import com.akostikov.datab.tables.PhanganSamuiTable;
import com.akostikov.datab.tables.PhanganTaoTable;
import com.akostikov.datab.tables.SamuiDonSakTable;
import com.akostikov.datab.tables.SamuiTaoTable;
import com.akostikov.datab.tables.SamuiPhanganTable;
import com.akostikov.datab.tables.TaoPhanganTable;
import com.akostikov.datab.tables.TaoSamuiTable;

import java.util.ArrayList;


public class FerryDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ferry.db";

    private DonSakSamuiTable donSakSamui = new DonSakSamuiTable();
    private SamuiDonSakTable samuiDonSak = new SamuiDonSakTable();
    private DonSakPhanganTable donSakPhangan = new DonSakPhanganTable();
    private PhanganDonSakTable phanganDonSak = new PhanganDonSakTable();
    private DonSakKohTaoTable donSakTao = new DonSakKohTaoTable();
    private KohTaoDonSakTable taoDonSak = new KohTaoDonSakTable();
    private SamuiPhanganTable samuiPhangan = new SamuiPhanganTable();
    private PhanganSamuiTable phanganSamui = new PhanganSamuiTable();
    private SamuiTaoTable samuiTao = new SamuiTaoTable();
    private TaoSamuiTable taoSamui = new TaoSamuiTable();
    private TaoPhanganTable taoPhangan = new TaoPhanganTable();
    private PhanganTaoTable phanganTao = new PhanganTaoTable();

    public FerryDBHelper(Context context)  {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create Tables
        db.execSQL(donSakSamui.createTable());
        donSakSamui.populateTable(db);

        db.execSQL(samuiDonSak.createTable());
        samuiDonSak.populateTable(db);

        db.execSQL(donSakPhangan.createTable());
        donSakPhangan.populateTable(db);

        db.execSQL(phanganDonSak.createTable());
        phanganDonSak.populateTable(db);

        db.execSQL(donSakTao.createTable());
        donSakTao.populateTable(db);

        db.execSQL(taoDonSak.createTable());
        taoDonSak.populateTable(db);

        db.execSQL(samuiPhangan.createTable());
        samuiPhangan.populateTable(db);

        db.execSQL(phanganSamui.createTable());
        phanganSamui.populateTable(db);

        db.execSQL(samuiTao.createTable());
        samuiTao.populateTable(db);

        db.execSQL(taoSamui.createTable());
        taoSamui.populateTable(db);

        db.execSQL(taoPhangan.createTable());
        taoPhangan.populateTable(db);

        db.execSQL(phanganTao.createTable());
        phanganTao.populateTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + donSakSamui.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + samuiDonSak.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + donSakPhangan.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + phanganDonSak.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + donSakTao.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + taoDonSak.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + samuiPhangan.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + phanganSamui.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + samuiTao.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + taoSamui.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + taoPhangan.getTableName() + ";");
        db.execSQL("DROP TABLE IF EXISTS " + phanganTao.getTableName() + ";");
        onCreate(db);
    }

    // Get data from table
    public void showInfo(String departure, String arrival, ArrayList<ListItem> tableItems)  {

        SQLiteDatabase dB = this.getReadableDatabase();

        String tableName = "name";

        if (departure.equals("Don_Sak") && arrival.equals("Samui"))
            tableName = donSakSamui.getTableName();

        if (departure.equals("Samui") && arrival.equals("Don_Sak"))
            tableName = samuiDonSak.getTableName();

        if (departure.equals("Don_Sak") && arrival.equals("Phangan"))
            tableName = donSakPhangan.getTableName();

        if (departure.equals("Phangan") && arrival.equals("Don_Sak"))
            tableName = phanganDonSak.getTableName();

        if (departure.equals("Don_Sak") && arrival.equals("Koh_Tao"))
            tableName = donSakTao.getTableName();

        if (departure.equals("Koh_Tao") && arrival.equals("Don_Sak"))
            tableName = taoDonSak.getTableName();

        if (departure.equals("Samui") && arrival.equals("Phangan"))
            tableName = samuiPhangan.getTableName();

        if (departure.equals("Phangan") && arrival.equals("Samui"))
            tableName = phanganSamui.getTableName();

        if (departure.equals("Samui") && arrival.equals("Koh_Tao"))
            tableName = samuiTao.getTableName();

        if (departure.equals("Koh_Tao") && arrival.equals("Samui"))
            tableName = taoSamui.getTableName();

        if (departure.equals("Phangan") && arrival.equals("Koh_Tao"))
            tableName = phanganTao.getTableName();

        if (departure.equals("Koh_Tao") && arrival.equals("Phangan"))
            tableName = taoPhangan.getTableName();

        Log.d("MYLOG", tableName);

        // Add column names to a table

        try {
            Cursor cursor = dB.rawQuery("SELECT * FROM " + tableName, null);

            int boatLogo = 0;

            if (cursor.moveToFirst()) {

                do {
                    String boat = cursor.getString(1);
                    String timeDepart = cursor.getString(2);
                    String pierDepart = cursor.getString(3);
                    String timeArrive = cursor.getString(4);
                    String pierArrive = cursor.getString(5);
                    String price = cursor.getString(6);

                    switch (boat)   {
                        case "Raja": boatLogo = R.drawable.raja; break;
                        case "Lomprayah": boatLogo = R.drawable.lomprayah; break;
                        case "Seatran": boatLogo = R.drawable.seatran; break;
                        case "Songserm": boatLogo = R.drawable.songserm; break;
                        case "Haadrin Queen": boatLogo = R.drawable.haadrin_queen; break;
                    }

                    tableItems.add(new ListItem(boatLogo, timeDepart, pierDepart, timeArrive, pierArrive, price));
                }
                while (cursor.moveToNext());
            } else Log.d("MYLOG", "Table is empty");

            cursor.close();
        }
        catch (SQLException ex) { ex.getStackTrace(); }

        dB.close();
    }
}

