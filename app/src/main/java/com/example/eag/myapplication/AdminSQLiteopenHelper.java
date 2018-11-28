package com.example.eag.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteopenHelper extends SQLiteOpenHelper {

    public AdminSQLiteopenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory , int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos){
        BaseDeDatos.execSQL("create table recetas (codigo int primary key,img int,nombre txt,nacio txt,puntuacion int,ingre int,ela int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }

}
