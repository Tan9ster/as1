package com.example.john.jianle_habittracker;

import java.util.Date;

/**
 * Created by john on 2016-09-30.
 */

public class habitItem {
    private String name;
    private Date date;
    private String daysOn; //might change this later

    public habitItem(){
        this.name="habit1";
        this.date=new Date();
        //this.daysOn=null;
    }

    public habitItem(String name){
        this.name=name;
        this.date=new Date();
        //this.daysOn=daysOn;
    }

    public String getName(){return name;}

    public Date getDate(){return date;}

    public String toString(){
        return  date.toString() + " | " + name;
    }
}
