package com.project.fun.the.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/* import from model */
import com.project.fun.the.myapplication.model.BDSQLiteHelper;
import com.project.fun.the.myapplication.model.Contact;

public class AddContactsActivity extends Activity {

    private BDSQLiteHelper database;
    private EditText name;
    private EditText phonerNumber;
    private Button btnNewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        database = new BDSQLiteHelper(this);

        name = (EditText) findViewById(R.id.editTextName);
        phonerNumber = (EditText) findViewById(R.id.editTextPhone);

        btnNewContact = (Button) findViewById(R.id.btnAddNewContact);

        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!name.getText().toString().isEmpty() && !phonerNumber.getText().toString().isEmpty()) {
                    Contact contact = new Contact();
                    contact.setName(name.getText().toString());
                    contact.setPhonernumber(phonerNumber.getText().toString());
                    contact.setEmail("myEmail@example.com".toString());
                    database.addContact(contact);

                    Toast.makeText(getBaseContext(), name.getText().toString()+" Was added!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), phonerNumber.getText().toString()+" All campuses must be completed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
