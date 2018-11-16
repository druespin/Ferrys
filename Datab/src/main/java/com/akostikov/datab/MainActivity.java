package com.akostikov.datab;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.akostikov.datab.data.FerryContract;
import com.akostikov.datab.data.FerryDBHelper;

public class MainActivity extends Activity {

    private FerryDBHelper dbHelper;

    String from, to;

    Spinner spin1, spin2;
    Button btnSearch;
    TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        btnSearch = findViewById(R.id.search);
        textOutput = findViewById(R.id.output);

        setupSpinner();

        dbHelper = new FerryDBHelper(this);

        insertRow();

        //Вывод расписания по заданным значениям
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // textOutput.setText("done");
            displayDatabaseInfo();
            }
        });
    }

    //Обработка значений спиннеров

    private void setupSpinner() {

        ArrayAdapter spinAdapter1 = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);

        ArrayAdapter spinAdapter2 = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);

        spinAdapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinAdapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spin1.setAdapter(spinAdapter1);
        spin2.setAdapter(spinAdapter2);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        from = spin1.getSelectedItem().toString();

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        to = spin2.getSelectedItem().toString();
    }

    private void displayDatabaseInfo()  {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        FerryContract contract = new FerryContract(from, to);

        String table = contract.getTable_name();
        String[] columns = contract.getColumns();

        Cursor cursor = db.query(table, columns, null, null, null, null,null);

        while (cursor.moveToNext()) {
            String boat = cursor.getString(1);
            String departure = cursor.getString(2);
            String arrival = cursor.getString(3);
            String travelTime = cursor.getString(4);
            String price = cursor.getString(5);

            String line = boat + "," + departure + "," + arrival + "," + travelTime + "," + price + '\n';
            textOutput.setText(line);
            Log.d("MYLOG", "line");
        }
        cursor.close();
    }

    //Вставка строки в таблицу
    private void insertRow() {
        // Gets the database in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        FerryContract contract = new FerryContract("Donsak", "Samui");
        ContentValues values = new ContentValues();

        values.put(contract.COLUMN_BOAT, "Raja");
        values.put(contract.COLUMN_DEPARTURE, "7:00");
        values.put(contract.COLUMN_ARRIVAL, "8:30");
        values.put(contract.COLUMN_TRAVEL_TIME, "1h30m");
        values.put(contract.COLUMN_PRICE, "140B");

        long newRow = db.insert(contract.getTable_name(), null, values);

        if (newRow == -1) {
            // Если ID  -1, значит произошла ошибка
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
        }
    }
}


