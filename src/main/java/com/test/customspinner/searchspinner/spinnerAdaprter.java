package com.test.customspinner.searchspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.customspinner.R;

import java.util.ArrayList;

/**
 * Created by praveen on 17/9/16.
 */
public class spinnerAdaprter extends BaseAdapter {
    ArrayList<spinnerPojo> spinnerData = null;
    LayoutInflater inflater;
    Context c;
    public spinnerAdaprter(Context c ,ArrayList<spinnerPojo> t){
        this.spinnerData=t;
        this.c = c;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return spinnerData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = inflater.inflate(R.layout.custom_spinner_row,viewGroup, false);
        TextView label = (TextView)row.findViewById(R.id.text);
        spinnerPojo sp = spinnerData.get(i);
        label.setText(sp.getVal());
        return row;
    }
}
