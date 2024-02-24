package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {
    private EditText Id,Name,PhoneNumber,status;

    private int vitri;

    private enum Error
    {
        NameISNull
    }

    private Button btnThem, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Id = findViewById(R.id.edit_ID);
        Name = findViewById(R.id.edit_Name);
        PhoneNumber = findViewById(R.id.edit_SDT);
        btnThem = findViewById(R.id.btnOK);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(Id.getText().toString());
                String name = Name.getText().toString();
                String phone = PhoneNumber.getText().toString();
                String tmp = status.getText().toString();

                boolean stt;
                if (tmp == "true")
                    stt = true;
                else stt = false;
                if(phone.length() != 10 || phone.matches("^[0-9]+$") == false)
                    Toast.makeText(SubActivity.this, "Hãy nhập số điện thoại hợp lệ", Toast.LENGTH_LONG).show();
                else
                {
                    Intent intent = new Intent();
                    Bundle b = new Bundle();
                    b.putInt("Id", id);
                    b.putString("Name", name);
                    b.putString("Phone", phone);
                    b.putBoolean("Status",stt);
                    intent.putExtras(b);
                    setResult(150, intent);
                    finish();
                }}
        });
    }



}