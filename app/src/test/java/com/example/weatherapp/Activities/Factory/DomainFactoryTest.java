package com.example.weatherapp.Activities.Factory;

import com.example.weatherapp.Activities.Domains.Hourly;
import com.example.weatherapp.Activities.Domains.TommorowDomain;

import junit.framework.TestCase;

public class DomainFactoryTest extends TestCase {

    public void testCreateHourlyDomain() {
        Object hourlyDomain = DomainFactory.createDomain("Hourly", "12 PM", 25, "/images/sunny.png");
        assertTrue(hourlyDomain instanceof Hourly);
        Hourly hourly = (Hourly) hourlyDomain;
        assertEquals("12 PM", hourly.getHour());
        assertEquals(25, hourly.getTemp());
        assertEquals("/images/sunny.png", hourly.getPicPath());
    }

    public void testCreateTomorrowDomain() {
        Object tomorrowDomain = DomainFactory.createDomain("Tommorow", "Monday", "/images/sunny.png", "Sunny", 30, 20);
        assertTrue(tomorrowDomain instanceof TommorowDomain);
        TommorowDomain tomorrow = (TommorowDomain) tomorrowDomain;
        assertEquals("Monday", tomorrow.getDay());
        assertEquals("/images/sunny.png", tomorrow.getPicPath());
        assertEquals("Sunny", tomorrow.getStatus());
        assertEquals(30, tomorrow.getHighTemp());
        assertEquals(20, tomorrow.getLowTemp());
    }

    public void testInvalidDomainType() {
        try {
            DomainFactory.createDomain("InvalidType", "Monday", "/images/sunny.png", "Sunny", 30, 20);
            fail("Expected IllegalArgumentException for invalid domain type");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid domain type", e.getMessage());
        }
    }

    public void testInvalidArgumentsForHourlyDomain() {
        try {
            DomainFactory.createDomain("Hourly", "12 PM", "25", "/images/sunny.png");
            fail("Expected IllegalArgumentException for invalid arguments for hourly domain");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments for Hourly domain creation", e.getMessage());
        }
    }

    public void testInvalidArgumentsForTomorrowDomain() {
        try {
            DomainFactory.createDomain("Tommorow", "Monday", "/images/sunny.png", "Sunny", "30", "20");
            fail("Expected IllegalArgumentException for invalid arguments for tomorrow domain");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid arguments for Tomorrow domain creation", e.getMessage());
        }
    }
}
