package com.project.fun.the.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;

import com.project.fun.the.myapplication.model.BDSQLiteHelper;
import com.project.fun.the.myapplication.model.Contact;

import java.util.ArrayList;

public class MyContactsActivity extends Activity {

    private BDSQLiteHelper database;
    ArrayList<Contact> listOfContacts;
    private SearchView searchViewContact;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts);



    }
}
