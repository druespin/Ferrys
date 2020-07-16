package com.akostikov.app.results_view;

import com.akostikov.app.FerrysApp;
import com.akostikov.app.database.RoomItem;
import com.akostikov.app.database.FerrysDb;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ResultsRepo {

    private FerrysDb db;
    private String departure;
    private String arrival;
    private ExecutorService executor;

    ResultsRepo(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
        db = FerrysApp.getInstance().getDatabase();
        executor = Executors.newSingleThreadExecutor();
    }

    List<RoomItem> getItems() throws ExecutionException, InterruptedException {
        return executor.submit(() ->
                db.itemDao().getItemsFromDb(departure, arrival))
                .get();
    }
}
