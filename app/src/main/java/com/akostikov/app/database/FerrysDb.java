package com.akostikov.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RoomItem.class}, version = 2)
public abstract class FerrysDb extends RoomDatabase {

    public abstract ItemDao itemDao();
}
