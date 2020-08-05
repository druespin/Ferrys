package com.akostikov.app.database;

import androidx.annotation.WorkerThread;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface ItemDao {

    @WorkerThread
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItems(List<RoomItem> items);

    @WorkerThread
    @Query("SELECT * FROM roomitem WHERE :departure IS departure AND :arrival IS arrival")
    List<RoomItem> getItemsFromDb(String departure, String arrival);

}
