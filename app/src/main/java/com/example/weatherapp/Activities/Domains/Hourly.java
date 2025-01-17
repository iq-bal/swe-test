package com.example.weatherapp.Activities.Domains;

import kotlin.text.UStringsKt;

public class Hourly implements Weather{
    private String Hour;
    private int temp;
    private String picPath;

    public Hourly(String hour, int temp, String picPath) {
        Hour = hour;
        this.temp = temp;
        this.picPath = picPath;
    }

    public String getHour() {
        return Hour;
    }

    public void setHour(String hour) {
        Hour = hour;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override
    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
