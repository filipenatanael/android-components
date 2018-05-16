package com.project.fun.the.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.fun.the.myapplication.model.Contact;

import java.util.ArrayList;

/**
 * Created by Filipe Natanael on 16/05/2018.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    private final Context context;
    private final ArrayList<Contact> elements;

    public ContactAdapter(Context context, ArrayList<Contact> elements) {
        super(context, R.layout.line_layout, elements);
        this.context = context;
        this.elements = elements;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.line_layout, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.txtViewName);
        TextView telefone = (TextView) rowView.findViewById(R.id.txtViewPhone);
        ImageView imgViewProfile = (ImageView) rowView.findViewById(R.id.imgViewProfile);

        nome.setText(elements.get(position).getName());
        telefone.setText(elements.get(position).getPhonernumber());

        imgViewProfile.setImageResource(R.drawable.profile);

        return rowView;
    }

}
