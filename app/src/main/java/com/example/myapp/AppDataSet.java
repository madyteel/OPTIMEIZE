package com.example.myapp;

import android.graphics.drawable.Drawable;

public class AppDataSet {
    private String name;
    private Drawable icon;
    private String packageName;
    private int status; // 0 = unlocked, 1 = locked

    // Constructor
    public AppDataSet(String name, Drawable icon, int status, String packageName) {
        this.name = name;
        this.icon = icon;
        this.status = status;
        this.packageName = packageName;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public int getStatus() {
        return status;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
