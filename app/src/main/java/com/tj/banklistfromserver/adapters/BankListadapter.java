package com.tj.banklistfromserver.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tj.banklistfromserver.R;
import com.tj.banklistfromserver.datas.Banks;

import java.util.List;

public class BankListadapter extends ArrayAdapter<Banks> {
    Context mContext;
    List<Banks> mList;
    LayoutInflater inf;

    public BankListadapter(Context context, List<Banks> list){
        super(context, R.layout.bank_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.bank_list_item,null);
        }

        Banks bankData = mList.get(position);


    return row;
    }

}
