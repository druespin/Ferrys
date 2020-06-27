package com.akostikov.app.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.akostikov.app.model.ListItem;
import com.akostikov.app.sqlite.FerryDBHelper;

import java.util.List;

public class ResultsPresenter implements ResultsView {

    private Context context;
    private String departure;
    private String arrival;
    private List<ListItem> tableItems;
    private FerryDBHelper dbHelper;

    public ResultsPresenter(Context context,
                            String departure,
                            String arrival,
                            List<ListItem> tableItems) {
        this.context = context;
        this.departure = departure;
        this.arrival = arrival;
        this.tableItems = tableItems;
    }

    @Override
    public void getItemsFromSQLite() {
        GetDataFromDbTask getDataTask = new GetDataFromDbTask();
        getDataTask.execute(tableItems);
    }


    @SuppressLint("StaticFieldLeak")
    class GetDataFromDbTask extends AsyncTask<List<ListItem>, Void, Void> {

        @Override
        protected Void doInBackground(List<ListItem>... listItems) {
            // Instance of db
            dbHelper = new FerryDBHelper(context);
            dbHelper.getDataFromDB(departure, arrival, tableItems);
            dbHelper.close();
            return null;
        }
    }
}
