package com.example.weatherapp.Activities.Observer;

import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;

import com.example.weatherapp.R;


public class User implements WeatherObserver {
    private Context context;

    public User(Context context) {
        this.context = context;
    }

    @Override
    public void onWeatherUpdate(String message) {
        // Show notification to the user
        showNotification(message);
    }

    private void showNotification(String message) {
        // Use Android notification system to show notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "weather_channel")
                    .setSmallIcon(R.drawable.cloudy) //notification icon
                    .setContentTitle("Weather Update")
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            // Show notification
            notificationManager.notify(1, builder.build());
        }
    }
}