package android.weather.json;

import android.weather.classes.City;

import com.google.gson.annotations.SerializedName;

public class ResponseCityListItem {
    @SerializedName("id") int cityId;
    @SerializedName("name") String cityName;
    @SerializedName("sys") ResponseCitySys responseCitySys;

    public City getCity() {
        int cityId = getCityId();
        String cityName = getCityName();
        String country = getCountry();
        City city = new City(cityId, cityName, country);
        return city;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public ResponseCitySys getResponseCitySys() {
        return responseCitySys;
    }

    public String getCountry() {
        return getResponseCitySys().getCountry();
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setResponseCitySys(ResponseCitySys responseCitySys) {
        this.responseCitySys = responseCitySys;
    }
}
