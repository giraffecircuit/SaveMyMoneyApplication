package com.example.admin.savemymoneyapplication;

/**
 * Created by Admin on 24-11-2017.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    ArrayList myList;

    String[] strBankAndFDArray={"Saving Account","Fixed Deposit","Recurring Deposit","Jan Dhan Account"};
    String[] strMutualFunds={"Purchase New Mutual Fund","SIP","Incremental SIP","SWP"};
    String[] strIndianPostalService={"Public Provident Fund","Recurring Deposit","Kisan Vikas Patra"};

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
        final TextView tView=(TextView)vw.findViewById(R.id.textView);
        tView.setText(myList.get(i).toString());
        tView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondLayerIntent=new Intent(context,Main2Activity.class);
                secondLayerIntent.putExtra("lstArray",strBankAndFDArray);
                context.startActivity(secondLayerIntent);
                //tView.setText("sdfsdf");
            }
        });
        return vw;
    }
}
