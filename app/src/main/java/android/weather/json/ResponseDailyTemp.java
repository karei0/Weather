package android.weather.json;

import com.google.gson.annotations.SerializedName;

public class ResponseDailyTemp {
    @SerializedName("day")
    double temperatureDay;
    @SerializedName("min")
    double temperatureMin;
    @SerializedName("max")
    double temperatureMax;
    @SerializedName("night")
    double temperatureNight;
    @SerializedName("eve")
    double temperatureEvening;
    @SerializedName("morn")
    double temperatureMorning;

    public double getTemperatureDay() {
        return temperatureDay;
    }

    public void setTemperatureDay(double temperatureDay) {
        this.temperatureDay = temperatureDay;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public double getTemperatureNight() {
        return temperatureNight;
    }

    public void setTemperatureNight(double temperatureNight) {
        this.temperatureNight = temperatureNight;
    }

    public double getTemperatureEvening() {
        return temperatureEvening;
    }

    public void setTemperatureEvening(double temperatureEvening) {
        this.temperatureEvening = temperatureEvening;
    }

    public double getTemperatureMorning() {
        return temperatureMorning;
    }

    public void setTemperatureMorning(double temperatureMorning) {
        this.temperatureMorning = temperatureMorning;
    }
}
