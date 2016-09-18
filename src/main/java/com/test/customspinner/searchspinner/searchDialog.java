package com.test.customspinner.searchspinner;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.test.customspinner.R;

import java.util.ArrayList;

/**
 * Created by praveen on 17/9/16.
 */
public class searchDialog extends DialogFragment {
    EditText t;
    private  String text;
    whileselect w;
    adp a;
    ArrayList<spinnerPojo> tmpData;
    ListView list;
    public searchDialog(){

    }
    public static searchDialog newInstance(ArrayList<spinnerPojo> data,whileselect wl) {
        searchDialog infoDialog = new searchDialog();
        infoDialog.tmpData = data;
        infoDialog.w = wl;
        return infoDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.search_dialog, container, false);
        getDialog().setTitle("Select Item");
        t = (EditText) rootView.findViewById(R.id.search_type_text);
        Button cls_btn = (Button) rootView.findViewById(R.id.cls_btn);
        cls_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(is)
                if(isVisible())
                    dismiss();
            }
        });
        t.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!t.getText().toString().equals("")){
                    a.setSearchText(t.getText().toString());
                    a.notifyDataSetChanged();
                }
            }
        });
        list = (ListView) rootView.findViewById(R.id.search_list);
        a = new adp(getActivity(),tmpData,"");
        list.setAdapter(a);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                w.position(i);
            }
        });
        t.setText("");
        return rootView;
    }
}
class adp extends BaseAdapter{
    Context c;
    ArrayList<spinnerPojo> tmpData;
    LayoutInflater inflater;
    String searchText = "";
    public adp(Context c , ArrayList<spinnerPojo> t,String searchText){
        this.c = c;
        this.searchText = searchText;
        this.tmpData = t;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public void setSearchText(String searchText){
        this.searchText = searchText;
        Log.i("praveen",""+searchText);
    }

    @Override
    public int getCount() {
        return this.tmpData.size();
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
        spinnerPojo sp = tmpData.get(i);
        label.setText(sp.getVal());

        if( searchText.equals("")|| (!searchText.equals("") && sp.getVal().startsWith(searchText))){
            label.setVisibility(View.VISIBLE);
        }else{
            label.setVisibility(View.GONE);
        }
        return row;

    }
}
