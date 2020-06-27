package com.akostikov.app.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.akostikov.app.ResultsActivity;

public class MainPresenter implements MainView {

    private Context context;

    public MainPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void checkSpinners(String departure, String arrival) {

        if (departure.equals("- DEPARTURE -")) {
            Toast.makeText(context, "Departure not selected", Toast.LENGTH_SHORT).show();
        }

        else if (arrival.equals("- ARRIVAL -")) {
            Toast.makeText(context, "Arrival not selected", Toast.LENGTH_SHORT).show();
        }

        else if (departure.equals(arrival))  {
            Toast.makeText(context, "Departure and Arrival should not match",
                    Toast.LENGTH_SHORT).show();
        }

        else {
            Intent intent = new Intent(context, ResultsActivity.class);
            intent.putExtra("dep", departure);
            intent.putExtra("arr", arrival);
            context.startActivity(intent);
        }
    }
}
