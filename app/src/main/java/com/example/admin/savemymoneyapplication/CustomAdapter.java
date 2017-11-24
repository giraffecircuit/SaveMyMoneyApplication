package com.example.admin.savemymoneyapplication;

/**
 * Created by Admin on 24-11-2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    ArrayList myList;

    public CustomAdapter(Context context, ArrayList myList) {
        this.context = context;
        this.myList = myList;
        inflater = LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int i) {
        return myList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vw=inflater.inflate(R.layout.custom_listview_layout, null, false);
        TextView tView=(TextView)vw.findViewById(R.id.textView);
        tView.setText(myList.get(i).toString());
        return vw;
    }
}
