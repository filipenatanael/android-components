package com.project.fun.the.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.project.fun.the.myapplication.model.BDSQLiteHelper;
import com.project.fun.the.myapplication.model.Contact;

import java.util.ArrayList;

public class MyContactsActivity extends Activity {

    private BDSQLiteHelper database;
    ArrayList<Contact> listOfContacts;
    private SearchView searchViewContactName;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts);



        searchViewContactName = (SearchView) findViewById(R.id.searchViewContactName);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(searchViewContactName.getQuery().toString().isEmpty()) {
                    ListView myList = (ListView) findViewById(R.id.listViewContacts);
                    listOfContacts = database.getAllContatcs();
                    ContactAdapter adapter = new ContactAdapter(MyContactsActivity.this, listOfContacts);
                    myList.setAdapter(adapter);

                    myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            //Toast.makeText(MyContactsActivity.this, listOfContacts.get(position).getName(), Toast.LENGTH_SHORT).show();
                            String phonenumber = listOfContacts.get(position).getPhonernumber().toString();
                            Uri uri = Uri.parse("tel:"+phonenumber);
                            Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                            startActivity(intent);
                        }
                    });
                } else {
                    ListView lista = (ListView) findViewById(R.id.listViewContacts);
                    listOfContacts = database.SearchContatcs(searchViewContactName.getQuery().toString());
                    ContactAdapter adapter = new ContactAdapter(MyContactsActivity.this, listOfContacts);
                    lista.setAdapter(adapter);

                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id) {
                            String phonenumber = listOfContacts.get(position).getPhonernumber().toString();
                            Uri uri = Uri.parse("tel:"+phonenumber);
                            Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                            startActivity(intent);
                        }
                    });

                }

            }
        });

    }
}
