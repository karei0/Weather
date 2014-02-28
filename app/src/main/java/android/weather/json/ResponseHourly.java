package android.weather.json;


import android.weather.classes.ForecastHourly;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseHourly {
    int cnt;
    @SerializedName("list")
    ArrayList<ResponseHourlyListItem> responseHourlyListItems;

    public ArrayList<ForecastHourly> getForecastHourlyList() {
        ArrayList<ForecastHourly> forecastHourlyList = new ArrayList<>();
        for (ResponseHourlyListItem h: responseHourlyListItems) {
            ForecastHourly forecastHourly = h.getForecastHourly();
            forecastHourlyList.add(forecastHourly);
        }
        return forecastHourlyList;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<ResponseHourlyListItem> getResponseHourlyListItems() {
        return responseHourlyListItems;
    }

    public void setResponseHourlyListItems(ArrayList<ResponseHourlyListItem> responseHourlyListItems) {
        this.responseHourlyListItems = responseHourlyListItems;
    }
}
