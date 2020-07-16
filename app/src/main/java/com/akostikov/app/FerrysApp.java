package com.akostikov.app;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.akostikov.app.database.FerrysDb;
import com.akostikov.app.database.InitialTableData;
import com.akostikov.app.database.RoomItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FerrysApp extends Application {

    private static FerrysApp appInstance;
    private static FerrysDb db;
    private static ExecutorService executor;
    private static final Object LOCK = new Object();

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        executor = Executors.newSingleThreadExecutor();
        if (db == null) {
            synchronized (LOCK) {
                db = Room.databaseBuilder(this, FerrysDb.class, "siam-ferrys.db")
                        .fallbackToDestructiveMigration()
                        .build();
                executor.submit(() ->  db.clearAllTables());
                uploadData();
            }
        }
    }

    public static FerrysApp getInstance() {
        return appInstance;
    }

    public FerrysDb getDatabase() {
        return db;
    }

    private void uploadData() {
        executor.submit(() -> {
            for (String[][] table : InitialTableData.getTables()) {
                db.itemDao().insertItems(getRoomItemFromTable(table));
                Log.d("DATABASE: ", db.itemDao().toString());
            }
        });
        executor.shutdown();
    }

    private List<RoomItem> getRoomItemFromTable(String[][] table) {
        List<RoomItem> items = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            items.add(new RoomItem(
                    table[i][0],
                    table[i][1],
                    table[i][2],
                    table[i][3],
                    table[i][4],
                    table[i][5],
                    table[i][6],
                    table[i][7]
            ));
        }
        return items;
    }
}
