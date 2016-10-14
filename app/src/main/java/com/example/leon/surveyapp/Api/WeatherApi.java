package com.example.leon.surveyapp.Api;

/**
 * Created by Leon on 10/12/2016.
 */
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("/data/2.5/weather")
    Call<Weather> getWeatherFromApi (
            @Query("q") String cityName,
            @Query("APPID") String appId);
}

