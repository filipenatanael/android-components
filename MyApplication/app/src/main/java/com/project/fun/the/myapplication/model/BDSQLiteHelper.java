package com.project.fun.the.myapplication.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by suporte on 09/05/2018.
 */

public class BDSQLiteHelper  extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final  String DATABASE_NAME = "ContactsDB";

    private static final String TBL_CONTACTS = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PHONERNUMBER = "phonernumber";
    private static final String[] COLUNM = { ID, NAME, EMAIL, PHONERNUMBER };


    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE contacts("+
                "id INTEGER PRIMARY KEY AOTOINCREMENT,"+
                "name TEXT,"+
                "email TEXT,"+
                "phonernumber TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS constacts");
    }
}
