package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnXoa;
    ListView lstviewContact;
    ArrayList<Contact> contactslist;
    AdapterContact ContactAdt;
    EditText edName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactslist = new ArrayList<>();
        contactslist.add(new Contact(1,"Mot","34567",true));
        contactslist.add(new Contact(2,"Hai","45678",false));
        contactslist.add(new Contact(3,"Ba","56789",true));

        ContactAdt = new AdapterContact(contactslist, this);

        lstviewContact = findViewById(R.id.listview);
        lstviewContact.setAdapter(ContactAdt);

        btnThem = findViewById(R.id.btnAdd);
        btnXoa = findViewById(R.id.btnDelete);
        edName = findViewById(R.id.edName);

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("do you want delete this item");
                builder.setMessage("delete");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < contactslist.size(); i++) {
                            if(contactslist.get(i).isStatus()) contactslist.remove(i);
                        }
                        ContactAdt.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("no", null);
                builder.create().show();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        //tao intent de mo activity
                        Intent intent = new Intent(MainActivity.this,SubActivity.class);

                        startActivityForResult(intent,100);//requestcode để đánh dấu lần yêu cầu để xử lý tình huống

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b = data.getExtras();
        // Lay du lieu tu Bundle
        int id = b.getInt("Id");
        String name = b.getString("Name");
        String phoneNumber = b.getString("PhoneNumber");
        String image = b.getString("");
        boolean status = b.getBoolean("Status");
        Contact newcontact = new Contact(id, name, phoneNumber, false);
        if (requestCode == 100 && resultCode ==150)
        {
            // THEM
            contactslist.add(newcontact);
            ContactAdt.notifyDataSetChanged();
    }
}}