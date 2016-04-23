package com.example.anjali.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anjali on 10-04-2016.
 */
public class DBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "info.db";
    public static final int DATABASE_VERSION= 1;
    public static final String TABLE_NAME= "Resigter";
    public static final String KEY_ID= "_id";
    //public static final String COL_NAME = "Name";
    //public static final int COL_INDEX1 = "_id";
    //public static final String COL_NAME1 = "Profession";
    public static final String KEY_NAME = "studentname";
public static final String KEY_PROFESSION = "studentprofession";
    private SQLiteDatabase db;



    private static final String DB_CREATE="create table "+TABLE_NAME+" ("
            +KEY_ID+" integer primary key "+ "autoincrement , " +
            ""+KEY_NAME+" text not null, "  +KEY_PROFESSION+" text not null);";



    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DB_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    public void insertEntry(String name, String profession) {

        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_PROFESSION,profession);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }



    public void deleteEntry(String studentname){

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + "WHERE " + KEY_NAME + "=\"" + studentname + "\";");

    }



    public String getEntry(){
        String dbString="";
        SQLiteDatabase db= getWritableDatabase();
        String query = "SELECT studentname FROM "+ TABLE_NAME+ " WHERE " +KEY_ID+ " = 1";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        dbString = c.getString(c.getColumnIndex("studentname"));

        /*c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("studentname "))!= null){

                dbString += c.getString(c.getColumnIndex("studentname"));
                dbString += "\n";

            }
            c.moveToNext();
        }

        db.close();*/
        return dbString;
    }





}
