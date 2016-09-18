package com.test.customspinner;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.customspinner.searchspinner.search_spinner;
import com.test.customspinner.searchspinner.spinnerPojo;

import java.util.ArrayList;
//android:padding="5dp"
//        android:textSize="15dp"
public class MainActivity extends AppCompatActivity {
    search_spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp  = (search_spinner) findViewById(R.id.search_spinner);
        sp.setSpinnerData(getData());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public ArrayList<spinnerPojo> getData(){
        ArrayList<spinnerPojo> t = new ArrayList<>();
        for(int i=0;i<30;i++){
            t.add(new spinnerPojo(i,"test "+i));
        }
        return t;
    }

}


