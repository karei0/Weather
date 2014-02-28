package android.weather.json;


import android.weather.classes.ForecastHourly;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseHourlyListItem {
    @SerializedName("dt") int time;
    @SerializedName("main") ResponseHourlyMain responseHourlyMain;
    @SerializedName("weather")
    ArrayList<ResponseHourlyDailyWeather> weatherArrayList;
    @SerializedName("wind")
    ResponseHourlyWind responseHourlyWind;

    public ForecastHourly getForecastHourly() {
        long time = getTime();
        int weatherId = getWeatherArrayList().get(0).getWeatherId();
        double temperature = getResponseHourlyMain().getTemperature();
        double pressure = getResponseHourlyMain().getPressure();
        double humidity = getResponseHourlyMain().getHumidity();
        double windSpeed = getResponseHourlyWind().getWindSpeed();
        double windDegree = getResponseHourlyWind().getWindDegree();
        ForecastHourly forecastHourly = new ForecastHourly(time, weatherId, temperature,
                pressure, humidity, windSpeed, windDegree);
        return forecastHourly;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ResponseHourlyMain getResponseHourlyMain() {
        return responseHourlyMain;
    }

    public void setResponseHourlyMain(ResponseHourlyMain responseHourlyMain) {
        this.responseHourlyMain = responseHourlyMain;
    }

    public ArrayList<ResponseHourlyDailyWeather> getWeatherArrayList() {
        return weatherArrayList;
    }

    public void setWeatherArrayList(ArrayList<ResponseHourlyDailyWeather> weatherArrayList) {
        this.weatherArrayList = weatherArrayList;
    }

    public ResponseHourlyWind getResponseHourlyWind() {
        return responseHourlyWind;
    }

    public void setResponseHourlyWind(ResponseHourlyWind responseHourlyWind) {
        this.responseHourlyWind = responseHourlyWind;
    }
}
