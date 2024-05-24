package com.example.weatherapp.Activities.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements WeatherSubject{
    private List<WeatherObserver> observers = new ArrayList<>();
    @Override
    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(String message) {
        for (WeatherObserver observer : observers) {
            observer.onWeatherUpdate(message);
        }
    }

    // Method to fetch weather data and notify observers
    public void fetchWeatherAndUpdateObservers() {
        // Fetch weather data
        String weatherData = fetchWeatherData();

        // Notify observers
        notifyObservers(weatherData);
    }

    private String fetchWeatherData() {
        // Fetch weather data from API or any other source
        return "Weather data fetched";
    }
}
