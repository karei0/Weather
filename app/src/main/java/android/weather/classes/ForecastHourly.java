package android.weather.classes;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ForecastHourly {
    private long time;
    private int weatherId;
    private double temperature;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private double windDegree;

    public ForecastHourly(long time, int weatherId, double temperature, double pressure,
                          double humidity, double windSpeed, double windDegree) {
        this.time = time;
        this.weatherId = weatherId;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
    }

    public int getTimeOfDay() {
        int timeOfDay;
        Date date = new Date();
        date.setTime(time * 1000);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        int hour = gregorianCalendar.get(Calendar.HOUR_OF_DAY);
        switch (hour) {
            case 0: timeOfDay = C.NIGHT; break;
            case 3: timeOfDay = C.NIGHT; break;
            case 6: timeOfDay = C.DAY; break;
            case 9: timeOfDay = C.DAY; break;
            case 12: timeOfDay = C.DAY; break;
            case 15: timeOfDay = C.DAY; break;
            case 18: timeOfDay = C.DAY; break;
            case 21: timeOfDay = C.NIGHT; break;
            default: timeOfDay = -1;
        }
        return timeOfDay;
    }

    public long getTime() {
        return time;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public double getTemperature() {
        return temperature;
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

    public void setTime(long time) {
        this.time = time;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }
}
