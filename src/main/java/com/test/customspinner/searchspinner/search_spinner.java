package com.test.customspinner.searchspinner;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.test.customspinner.R;

import java.util.ArrayList;

/**
 * Created by praveen on 17/9/16.
 */
public class search_spinner extends LinearLayout implements whileselect {
    private View mView;
    Context mycontext;
    Spinner sp_o;
    ImageView search_icon;
    ArrayList<spinnerPojo> tmp;
    private Activity activity ;
    searchDialog sd;

    public search_spinner(Context context) {
        super(context);
        this.mycontext = context;
        mView = inflate(this.mycontext, R.layout.custom_search,this);
        activity = (Activity) context;
    }

    public search_spinner(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.mycontext = context;
        activity = (Activity) context;
        mView = inflate(this.mycontext, R.layout.custom_search,this);
        sp_o = (Spinner) mView.findViewById(R.id.item_spinner);
        search_icon = (ImageView) findViewById(R.id.search_icon);
        search_icon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = activity.getFragmentManager();
                sd = new searchDialog().newInstance(tmp,search_spinner.this);
                sd.show(fm, "Sample Fragment");
            }
        });
    }

    public void setSpinnerData(ArrayList<spinnerPojo> t){
        tmp = t;
        spinnerAdaprter sp_adp = new spinnerAdaprter(this.mycontext,t);
        sp_o.setAdapter(sp_adp);
    }


    @Override
    public void position(int position) {
        sp_o.setSelection(position);
        sd.dismiss();
    }
}