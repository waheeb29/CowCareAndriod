package com.example.cowcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbname = "mydb";
    private static final int version = 1;

    public DBHelper(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Doctor_info(_id INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , MOBILE TEXT)";
        db.execSQL(sql);
        insertData("Dr Abdullah Razi", "+923064070787", db);
        insertData("Dr Waheeb Ur Rehman", "+9230406748244", db);
        insertData("Dr Mujtaba Hassan", "+923206947057", db);
        insertData("Dr Ahmad Butt", "+9290078601", db);



    }

    private void insertData(String name, String number, SQLiteDatabase database) {
        ContentValues values = new ContentValues();

        values.put("Name", name);
        values.put("Mobile", number);
        database.insert("Doctor_info", null, values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public Cursor display(){
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor cursor=database.rawQuery("Select * from Doctor_info",null);

        return cursor;

    }


}
