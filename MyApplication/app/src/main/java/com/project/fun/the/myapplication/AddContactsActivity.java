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
    private EditText editTextName;
    private EditText editTextPhone;
    private Button btnAddNewContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        btnAddNewContact = (Button) findViewById(R.id.btnAddNewContact);

        btnAddNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editTextName.getText().toString().isEmpty() && !editTextPhone.getText().toString().isEmpty()) {
                    Contact contato = new Contact();
                    contato.setName(editTextName.getText().toString());
                    contato.setName(editTextPhone.getText().toString());
                    database.addContact(contato);

                    Toast.makeText(getBaseContext(), editTextName.getText().toString()+" Was added!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), editTextPhone.getText().toString()+" All campuses must be completed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
