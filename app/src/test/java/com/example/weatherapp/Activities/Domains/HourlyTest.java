package com.example.weatherapp.Activities.Domains;

import junit.framework.TestCase;

public class HourlyTest extends TestCase {

    public void testGetHour() {
        Hourly hourly = new Hourly("12:00", 25, "/images/sunny.png");
        assertEquals("12:00", hourly.getHour());
    }

    public void testSetHour() {
        Hourly hourly = new Hourly("15:00", 30, "/images/sunny.png");
        hourly.setHour("18:00");
        assertEquals("18:00", hourly.getHour());
    }

    public void testGetTemp() {
        Hourly hourly = new Hourly("12:00", 25, "/images/sunny.png");
        assertEquals(25, hourly.getTemp());
    }

    public void testSetTemp() {
        Hourly hourly = new Hourly("15:00", 30, "/images/sunny.png");
        hourly.setTemp(20);
        assertEquals(20, hourly.getTemp());
    }

    public void testGetPicPath() {
        Hourly hourly = new Hourly("12:00", 25, "/images/sunny.png");
        assertEquals("/images/sunny.png", hourly.getPicPath());
    }

    public void testSetPicPath() {
        Hourly hourly = new Hourly("15:00", 30, "/images/sunny.png");
        hourly.setPicPath("/images/cloudy.png");
        assertEquals("/images/cloudy.png", hourly.getPicPath());
    }
}
