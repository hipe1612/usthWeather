package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WeatherAndForecastFragment extends Fragment {
    public static WeatherAndForecastFragment newInstance(String city){
        WeatherAndForecastFragment fragment = new WeatherAndForecastFragment();
        Bundle args = new Bundle();
        args.putString("city",city);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
                             Bundle savedInstanceState){
        Log.i("WeatherAndForecast","onCreate");

        return inflater.inflate(R.layout.weather_forecast_fragment,container,false);
    }
}
