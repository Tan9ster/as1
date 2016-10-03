package com.example.john.jianle_habittracker;

import java.util.Date;

/**
 * Created by john on 2016-09-30.
 */
//stores info about individual habit
public class habitItem {
    private String name;
    private Date date;
    private String daysOn; //might change this later

    public habitItem(String name, String daysOn){
        this.name=name;
        this.date=new Date();
        this.daysOn=daysOn;
    }

    public void setName(String name){ this.name=name;}
    public void setDate(Date date){this.date=date;}
    public void setDaysOn(String daysOn){ this.daysOn=daysOn;}
    public String getName(){return name;}
    public String getDaysOn(){return daysOn;}

    public Date getDate(){return date;}
//to print out to listview
    public String toString(){
        return  date.toString() + " | " + name.toString() + " | " + daysOn.toString();
    }
}
