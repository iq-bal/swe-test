package com.example.weatherapp.Activities.Domains;

import junit.framework.TestCase;

public class TommorowDomainTest extends TestCase {

    public void testGetDay() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        assertEquals("Monday", tomorrow.getDay());
    }

    public void testGetPicPath() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        assertEquals("/images/sunny.png", tomorrow.getPicPath());
    }

    public void testGetStatus() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        assertEquals("Sunny", tomorrow.getStatus());
    }

    public void testGetHighTemp() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        assertEquals(30, tomorrow.getHighTemp());
    }

    public void testGetLowTemp() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        assertEquals(20, tomorrow.getLowTemp());
    }

    public void testSetDay() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        tomorrow.setDay("Tuesday");
        assertEquals("Tuesday", tomorrow.getDay());
    }

    public void testSetPicPath() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        tomorrow.setPicPath("/images/cloudy.png");
        assertEquals("/images/cloudy.png", tomorrow.getPicPath());
    }

    public void testSetStatus() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        tomorrow.setStatus("Cloudy");
        assertEquals("Cloudy", tomorrow.getStatus());
    }

    public void testSetHighTemp() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        tomorrow.setHighTemp(35);
        assertEquals(35, tomorrow.getHighTemp());
    }

    public void testSetLowTemp() {
        TommorowDomain tomorrow = new TommorowDomain("Monday", "/images/sunny.png", "Sunny", 30, 20);
        tomorrow.setLowTemp(25);
        assertEquals(25, tomorrow.getLowTemp());
    }
}
