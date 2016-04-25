package com.example.anjali.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Anjali on 10-04-2016.
 */
public class DBHelper {
    public static final String DATABASE_NAME = "Student_Exam";
    public static final int DATABASE_VERSION= 1;
    public static final String TABLE_NAME= "Resigter";
    public static final String KEY_ID= "_id";
    public static final String KEY_NAME = "studentname";
    public static final String KEY_EMAIL = "studentemail";
    public static final String KEY_PASSWORD = "studentpassword";
    public static final String KEY_PROFESSION = "studentprofession";



    private static final String DB_CREATE="create table "+TABLE_NAME+" ("
            +KEY_ID+" integer primary key "+ "autoincrement , " +
            ""+KEY_NAME+" text not null, "
            + KEY_EMAIL+" text not null, "
            + KEY_PASSWORD+" text not null, "
            +KEY_PROFESSION+" text not null);";

    private SQLiteDatabase db;
    private final Context context;
    private MyDBAdapter helper;


    public DBHelper (Context context)
    {
        this.context = context;
        helper = new MyDBAdapter(context,DATABASE_NAME, null, DATABASE_VERSION);
    }



    public DBHelper open(){
        db = helper.getWritableDatabase();
        return this;
    }


    public void close()
    {
        db.close();
    }



    public void insertEntry(String name,String email,String password ,String profession) {

        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_EMAIL,email);
        contentValues.put(KEY_PASSWORD,password);
        contentValues.put(KEY_PROFESSION, profession);

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }



    public void deleteEntry(String studentname){

        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + "WHERE " + KEY_NAME + "=\"" + studentname + "\";");

    }

    public boolean verifyUser(String email, String password){
        String[] verify = new String[2];
        Cursor  cur= db.rawQuery("select " + KEY_EMAIL+","+ KEY_PASSWORD+" from "+TABLE_NAME, null);
        cur.moveToFirst();
        verify[0] = cur.getString(cur.getColumnIndex(KEY_EMAIL));
        verify[1] = cur.getString(cur.getColumnIndex(KEY_PASSWORD));
        while(cur.moveToNext())
        {
            verify[0] = cur.getString(cur.getColumnIndex(KEY_EMAIL));
            verify[1] = cur.getString(cur.getColumnIndex(KEY_PASSWORD));
            if(verify[0].equals(email) || verify[1].equals(password)) {
                break;
            }

        }
        cur.close();
        if(verify[0].equals(email) && verify[1].equals(password)){
            return true;
        }
        else {
            return false;
        }

    }




    public String getEntry(){
        String dbString="";
        SQLiteDatabase db= helper.getWritableDatabase();
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
    private static class MyDBAdapter extends SQLiteOpenHelper {

        public MyDBAdapter(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL(DB_CREATE);
            }


        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
            Log.w("Updation", "Data base version is being updates");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_CREATE);
            onCreate(sqLiteDatabase);
        }

    }





}
