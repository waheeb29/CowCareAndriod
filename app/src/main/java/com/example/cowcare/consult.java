
package com.example.cowcare;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

        public class consult extends AppCompatActivity {

        SQLiteDatabase database;
        Cursor cursor;
        ListView list;
        DBHelper helper;
        ListAdapter listAdapter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        list = findViewById(R.id.doctor_list);
        listAdapter = new ListAdapter(getApplicationContext(), R.layout.row);
        helper = new DBHelper(getApplicationContext());
        database = helper.getReadableDatabase();
        cursor = helper.display();
        list.setAdapter(listAdapter);

        if (cursor.moveToFirst()) {
        do {
        String name, number;
        name = cursor.getString(1);
        number = cursor.getString(2);

        DataProvider dataProvider = new DataProvider(name, number);
        listAdapter.add(dataProvider);

        } while (cursor.moveToNext());
        }

        }
        }






