package com.example.mtrsliit.it17126670;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "movies.db";
    public static final String Table_Name1 = " FilmDetails";
    public static final String COL_1 = " ID";
    public static final String COL_2 = "filmName";
    public static final String COL_3 = "filmDirectorID";
    public static final String COL_4 = "filmCategory";

    public static final String Table_Name2 = " DirectorDetails";
    public static final String CO_1 = " ID";
    public static final String CO_2 = " directorName";


    public DBHandler(context.MainActivity context) {
        super(context,DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate() {
        onCreate();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table FilmDetails"+
        "(ID integer primary key,filmName text, filmDirectorID integer,filmCategory text)");

        db.execSQL("create table DirectorDetails"+
                "(ID integer primary key, directorName text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FilmDetails");
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS DirectorDetails");
        onCreate(db);


    }
    public boolean insertFilmDetails (Integer ID, String filmName, Integer filmDirectorID, String filmCategory) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("filmName", filmName);
        contentValues.put("filmDirectorID", filmDirectorID);
        contentValues.put("filmCategory", filmCategory);

        db.insert("FilmDetails", null, contentValues);
        return true;

}
    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("FilmDetails",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllFilmDetails() {
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from FilmDetails", null );
        boolean b = res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COL_1)));
            res.moveToNext();
        }
        return array_list;
    }
}



