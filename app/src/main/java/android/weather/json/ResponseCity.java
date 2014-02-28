package android.weather.json;


import android.weather.classes.City;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseCity {
    @SerializedName("count") int citiesCount;
    @SerializedName("list") ArrayList<ResponseCityListItem> cityListItems;

    public ArrayList<City> getCityList() {
        ArrayList<City> cityList = new ArrayList<>();
        for (ResponseCityListItem c: cityListItems) {
            City city = c.getCity();
            cityList.add(city);
        }
        return cityList;
    }

    public int getCitiesCount() {
        return citiesCount;
    }

    public void setCitiesCount(int citiesCount) {
        this.citiesCount = citiesCount;
    }

    public ArrayList<ResponseCityListItem> getCityListItems() {
        return cityListItems;
    }

    public void setCityListItems(ArrayList<ResponseCityListItem> cityListItems) {
        this.cityListItems = cityListItems;
    }
}
