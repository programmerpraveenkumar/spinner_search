package com.test.customspinner.searchspinner;

/**
 * Created by praveen on 17/9/16.
 */
public class spinnerPojo {
    private int id;
    private String val;
    public spinnerPojo(int id,String val){
        this.id = id;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
