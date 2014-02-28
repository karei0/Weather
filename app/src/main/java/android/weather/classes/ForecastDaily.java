package android.weather.classes;

public class ForecastDaily {
    private long time;
    private int weatherId;
    private double temperatureMax;
    private double temperatureMin;
    private double temperatureMorning;
    private double temperatureDay;
    private double temperatureEvening;
    private double temperatureNight;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDegree;

    public ForecastDaily(long time, int weatherId, double temperatureMax, double temperatureMin,
                         double temperatureMorning, double temperatureDay,
                         double temperatureEvening, double temperatureNight, double pressure,
                         double humidity, double windSpeed, double windDegree) {
        this.time = time;
        this.weatherId = weatherId;
        this.temperatureMax = temperatureMax;
        this.temperatureMin = temperatureMin;
        this.temperatureMorning = temperatureMorning;
        this.temperatureDay = temperatureDay;
        this.temperatureEvening = temperatureEvening;
        this.temperatureNight = temperatureNight;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
    }

    public long getTime() {
        return time;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public double getTemperatureMorning() {
        return temperatureMorning;
    }

    public double getTemperatureDay() {
        return temperatureDay;
    }

    public double getTemperatureEvening() {
        return temperatureEvening;
    }

    public double getTemperatureNight() {
        return temperatureNight;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }
}
