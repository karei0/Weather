package android.weather.json;

import android.weather.classes.ForecastDaily;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseDaily {
    int cnt;
    @SerializedName("list")
    ArrayList<ResponseDailyListItem> responseDailyListItems;

    public ArrayList<ForecastDaily> getForecastDailyList() {
        ArrayList<ForecastDaily> forecastDailyArrayList = new ArrayList<>();
        for (ResponseDailyListItem d: responseDailyListItems) {
            forecastDailyArrayList.add(d.getForecastDaily());
        }
        return forecastDailyArrayList;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<ResponseDailyListItem> getResponseDailyListItems() {
        return responseDailyListItems;
    }

    public void setResponseDailyListItems(ArrayList<ResponseDailyListItem> responseDailyListItems) {
        this.responseDailyListItems = responseDailyListItems;
    }
}
