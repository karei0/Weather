package android.weather.json;

import android.weather.classes.ForecastDaily;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseDailyListItem {
    @SerializedName("dt") int time;
    @SerializedName("temp") ResponseDailyTemp dailyTemp;
    double pressure;
    int humidity;
    @SerializedName("weather") ArrayList<ResponseHourlyDailyWeather> weatherArrayList;
    @SerializedName("speed") double windSpeed;
    @SerializedName("deg") double windDegree;

    public ForecastDaily getForecastDaily() {
        long time = getTime();
        int weatherId = getWeatherArrayList().get(0).getWeatherId();
        double temperatureMax = getDailyTemp().getTemperatureMax();
        double temperatureMin = getDailyTemp().getTemperatureMin();
        double temperatureMorning = getDailyTemp().getTemperatureMorning();
        double temperatureDay = getDailyTemp().getTemperatureDay();
        double temperatureEvening = getDailyTemp().getTemperatureEvening();
        double temperatureNight = getDailyTemp().getTemperatureNight();
        double pressure = getPressure();
        double humidity = getHumidity();
        double windSpeed = getWindSpeed();
        double windDegree = getWindDegree();

        ForecastDaily forecastDaily = new ForecastDaily(time, weatherId, temperatureMax, temperatureMin,
                temperatureMorning, temperatureDay, temperatureEvening, temperatureNight,
                pressure, humidity, windSpeed, windDegree);
        return forecastDaily;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ResponseDailyTemp getDailyTemp() {
        return dailyTemp;
    }

    public void setDailyTemp(ResponseDailyTemp dailyTemp) {
        this.dailyTemp = dailyTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public ArrayList<ResponseHourlyDailyWeather> getWeatherArrayList() {
        return weatherArrayList;
    }

    public void setWeatherArrayList(ArrayList<ResponseHourlyDailyWeather> weatherArrayList) {
        this.weatherArrayList = weatherArrayList;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }
}
