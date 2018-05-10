package com.project.fun.the.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by Filipe Natanael on 09/05/2018.
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

    public void addContact (Contact contact) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, contact.getName());
        values.put(EMAIL, contact.getEmail());
        values.put(PHONERNUMBER, contact.getPhonernumber());
        database.insert(TBL_CONTACTS, null, values);
    }

    private Contact cursorToContact(Cursor cursor) {
        Contact contact = new Contact();
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setEmail(cursor.getString(2));
        contact.setPhonernumber(cursor.getString(3));
        return contact;
    }

    public Contact getContact(int id) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TBL_CONTACTS,
                COLUNM,
                " id = ?",
                new String[] { String.valueOf(id) },
                null,
                null,
                null,
                null);
        if (cursor == null) {
            //if(row == null);
            return null;
        } else {
            cursor.moveToFirst();
            Contact contact = cursorToContact(cursor);
            return contact;
        }
    }

    public ArrayList<Contact> getAllContatcs(){
        ArrayList<Contact> listContatcs = new ArrayList<Contact>();
        String query = "SELECT * FROM "+TBL_CONTACTS;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Contact contato = cursorToContact(cursor);
                listContatcs.add(contato);
            } while (cursor.moveToNext());
        }
        return listContatcs;
    }



}
