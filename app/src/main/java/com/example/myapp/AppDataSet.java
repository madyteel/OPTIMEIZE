package com.example.myapp;

import android.graphics.drawable.Drawable;

public class AppDataSet {

    String appname;
    Drawable appIcon;
    int status; // status = 0 -> unlocked. else, locked.
    String packagename;

   //constructor.
    public AppDataSet(String appname, Drawable appIcon, int status, String packagename){
        this.appname = appname;
        this.appIcon = appIcon;
        this.status = status;
        this.packagename = packagename;
    }

    //getters
    public String getAppname(){
        return appname;
    }
    public String getPackagename(){
        return packagename;
    }
    public Drawable getAppIcon(){
        return appIcon;
    }
    public int getStatus(){
        return status;
    }

    //setters
    public void setAppname(String s){
        this.appname = s;
    }
    public void setAppIcon(Drawable d){
        this.appIcon = d;
    }
    public void setStatus(int i){
        this.status = i;
    }
    public void setPackagename(String s){
        this.packagename = s;
    }
}
