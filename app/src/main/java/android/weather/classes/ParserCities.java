package android.weather.classes;

import android.weather.json.ResponseCity;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParserCities implements Callable<ResponseCity> {
    private String requestString;
    private final String searchString = "http://api.openweathermap.org/data/2.5/find?";

    public ParserCities(String cityName) {
        requestString = searchString + "q=" + cityName;
    }

    public ParserCities(double latutude, double longitude) {
        requestString = searchString + "?lat=" + latutude + "&lon=" + longitude;
    }

    public ArrayList<City> getCityList() {
        ArrayList<City> cityList = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<ResponseCity> responseCityFuture = executorService.submit(
                this);
        try {
            ResponseCity responseCity = responseCityFuture.get();
            cityList = responseCity.getCityList();
//            logMsg("cities: "+cityList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        return cityList;
    }

    @Override
    public ResponseCity call() throws Exception {
        URL url = new URL(requestString);
        ResponseCity responseCity = null;
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(30 * 1000);
        connection.setReadTimeout(30 * 1000);
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            Gson gson = new Gson();
            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
            responseCity = gson.fromJson(inputStreamReader, ResponseCity.class);
        }
        return responseCity;
    }
}
