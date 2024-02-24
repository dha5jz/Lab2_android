package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContact extends BaseAdapter {
    private ArrayList<Contact> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterContact(ArrayList<Contact> data, Context context){
        this.data = data;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View v = convertView;
       if(v == null)
           v = layoutInflater.inflate(R.layout.custom,null);
        TextView tvName = v.findViewById(R.id.tvName);
        TextView tvPhone = v.findViewById(R.id.tvPhone);

        tvName.setText(data.get(position).getName());
        tvPhone.setText(data.get(position).getPhoneNum());

        CheckBox cb = v.findViewById(R.id.ckbox);
        cb.setChecked(data.get(position).isStatus());
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setStatus(cb.isChecked());
            }
        });
        return v;
    }
}
