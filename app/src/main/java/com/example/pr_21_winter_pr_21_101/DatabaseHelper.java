package com.example.pr_21_winter_pr_21_101;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "usertor.db";
    //название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "users"; // название таблицы в бд
    //азвания столбцов
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_YEAR = "year";

    public DatabaseHelper (Context context) {
        super (context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + "TEXT,"  + COLUMN_YEAR + "INTEGER);");
        // добавление начальных данных
        db.execSQL("INSERT INTO "+ TABLE +"(" + COLUMN_NAME + "," + COLUMN_YEAR +") VALUES ('Том Смит', 1981);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);

    }
}