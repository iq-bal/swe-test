package com.example.weatherapp.Activities.Observer;

public interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers(String message);
}
