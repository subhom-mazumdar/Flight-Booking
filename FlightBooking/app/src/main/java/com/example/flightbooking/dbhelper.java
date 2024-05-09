package com.example.flightbooking;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public static final String dbname="Flight_Booking";
    public dbhelper(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q1="create table user(uid text, name text, password text)";
        db.execSQL(q1);
        String q2="create table booking(pnr integer primary key autoincrement,name text, pass_num integer, travel_class text, date text)";
        db.execSQL(q2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean add_user(String uid, String name, String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("uid",uid);
        cv.put("name",name);
        cv.put("password",password);
        long send=db.insert("user",null,cv);
        if(send!=-1)
            return false;
        else
            return true;
    }
    public void add_booking(String name,int pass_num,String travel_class,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("pass_num",pass_num);
        cv.put("travel_class",travel_class);
        cv.put("date",date);
        db.insert("booking",null,cv);
    }
    public boolean login(String user,String pass)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        boolean chk=false;
        if(db!=null)
        {
            db.rawQuery("select * from user where uid='"+user+"' and password='"+pass+"'",null);
        }
        if(cursor.getCount()!=0)
            chk=true;
        return chk;
    }
}
