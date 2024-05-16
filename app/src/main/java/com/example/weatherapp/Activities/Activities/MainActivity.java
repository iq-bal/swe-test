package com.example.weatherapp.Activities.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.Activities.Adapter.HourlyAdapter;
import com.example.weatherapp.Activities.Domains.Hourly;
import com.example.weatherapp.Activities.Factory.DomainFactory;
import com.example.weatherapp.Activities.SingleTon.WeatherApiClient; // Import the singleton
import com.example.weatherapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity"; // Define TAG constant
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    private WeatherApiClient weatherApiClient;
    private TextView windTxt, humidityTxt, tempTodayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherApiClient = WeatherApiClient.getInstance(this); // Initialize the singleton

        // Applying edge-to-edge for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        windTxt = findViewById(R.id.windSpeedText);
        humidityTxt = findViewById(R.id.humidityText);
        tempTodayText = findViewById(R.id.tempTodayText);

        initRecyclerview();
        setVariable();

        // Fetch weather data
        fetchWeatherData("london");
    }

    private void setVariable() {
        TextView next7DayBtn = findViewById(R.id.nextBtn);
        next7DayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TommorrowActivity.class));
            }
        });
    }

    private void initRecyclerview() {
        ArrayList<Hourly> items = new ArrayList<>();
        items.add((Hourly) DomainFactory.createDomain("Hourly", "10 PM", 28, "cloudy"));
        items.add((Hourly) DomainFactory.createDomain("Hourly", "11 PM", 29, "sunny"));
        items.add((Hourly) DomainFactory.createDomain("Hourly", "12 PM", 30, "wind"));
        items.add((Hourly) DomainFactory.createDomain("Hourly", "01 AM", 29, "rainy"));
        items.add((Hourly) DomainFactory.createDomain("Hourly", "02 AM", 27, "storm"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterHourly = new HourlyAdapter(this, items);
        recyclerView.setAdapter(adapterHourly);
    }



    private void fetchWeatherData(String city) {
        new FetchWeatherTask().execute(city);
    }

    private class FetchWeatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String city = params[0];
            return weatherApiClient.fetchWeatherData(city);
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                Log.d(TAG, "API response received: " + result);
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    // Parse the JSON response and update the UI accordingly
                    double temperature = jsonObject.getDouble("temperature");
                    double humidity = jsonObject.getDouble("humidity");
                    double windSpeed = jsonObject.getDouble("windSpeed");

                    // Update the UI with the parsed data
                    tempTodayText.setText(String.valueOf(temperature));
                    humidityTxt.setText(String.valueOf(humidity * 100));
                    windTxt.setText(String.valueOf(windSpeed));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
