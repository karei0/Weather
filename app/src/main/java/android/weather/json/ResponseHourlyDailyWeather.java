package android.weather.json;


import com.google.gson.annotations.SerializedName;

public class ResponseHourlyDailyWeather {
    @SerializedName("id") int weatherId;

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }
}
