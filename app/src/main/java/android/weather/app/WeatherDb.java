package android.weather.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.weather.classes.C;
import android.weather.classes.City;
import android.weather.classes.ForecastDaily;
import android.weather.classes.ForecastHourly;

import java.util.ArrayList;
import java.util.Formatter;

public class WeatherDb extends SQLiteOpenHelper {
    public static final String CITY_TABLE = "CityTable";
    public static final String HOURLY_TABLE = "HourlyTable";
    public static final String DAILY_TABLE = "DailyTable";

    public static final String CITY_ID = "cityId";
    public static final String CITY_NAME = "cityName";
    public static final String COUNTRY_CODE = "countryCode";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    public static final String DATE_UNIX = "dateUnix";
    public static final String TEMPERATURE = "temp";
    public static final String PRESSURE = "pressure";
    public static final String HUMIDITY = "humidity";
    public static final String WEATHER_ID = "weatherId";
    public static final String WIND_SPEED = "windSpeed";
    public static final String WIND_DEGREE = "windDegree";

    public static final String TEMP_DAY = "tempDay";
    public static final String TEMP_MIN = "tempMin";
    public static final String TEMP_MAX = "tempMax";
    public static final String TEMP_NIGHT = "tempNight";
    public static final String TEMP_EVE = "tempEve";
    public static final String TEMP_MORN = "tempMorn";

    private static final String DATABASE_NAME = "WeatherDB.db";
    private static final String CITY_TABLE_CITY_ID = CITY_TABLE + "." + CITY_ID;
    private static final String HOURLY_TABLE_CITY_ID = HOURLY_TABLE + "." + CITY_ID;
    private static final String DAILY_TABLE_CITY_ID = DAILY_TABLE + "." + CITY_ID;
    private SQLiteDatabase db;

    public WeatherDb(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public boolean putCityInDb(City city) {
        db = this.getWritableDatabase();
        int cityId = city.getCityId();
        db.delete(CITY_TABLE, CITY_ID + " = " + cityId, null);
//        String cityName;
//        String countryCode;
//        double latitude;
//        double longitude;
//        cityId = city.getCityId();
//        cityName = city.getCityName();
//        countryCode = city.getCountryCode();
//        latitude = city.getLatitude();
//        longitude = city.getLongitude();

        ContentValues cvCity = new ContentValues();
        cvCity.put(CITY_ID, cityId);
        cvCity.put(CITY_NAME, city.getCityName());
        cvCity.put(COUNTRY_CODE, city.getCountry());
//        cvCity.put(LATITUDE, city.getLatitude());
//        cvCity.put(LONGITUDE, city.getLongitude());
        db.insert(CITY_TABLE, null, cvCity);
        this.close();
        return true;
    }

    public boolean putHourlyForecastInDb(ArrayList<ForecastHourly> weatherHourlyList, int cityId) {
        db = this.getWritableDatabase();
        if (db != null) {
            db.delete(HOURLY_TABLE, CITY_ID + " = " + cityId, null);
        }
        ContentValues cvHourly = new ContentValues();
        for (ForecastHourly h: weatherHourlyList) {
            cvHourly.put(CITY_ID, cityId);
            cvHourly.put(DATE_UNIX, h.getTime());
            cvHourly.put(WEATHER_ID, h.getWeatherId());
            cvHourly.put(TEMPERATURE, h.getTemperature());
            cvHourly.put(PRESSURE, h.getPressure());
            cvHourly.put(HUMIDITY, h.getHumidity());
            cvHourly.put(WIND_SPEED, h.getWindSpeed());
            cvHourly.put(WIND_DEGREE, h.getWindDegree());
            db.insert(HOURLY_TABLE, null, cvHourly);
        }
        this.close();
        return true;
    }

    public boolean putDailyForecastInDb(ArrayList<ForecastDaily> weatherDailyList, int cityId) {
        db = this.getWritableDatabase();
        if (db != null) {
            db.delete(DAILY_TABLE, CITY_ID + " = " + cityId, null);
        }
        ContentValues cvDaily = new ContentValues();
        for (ForecastDaily d: weatherDailyList) {
            cvDaily.put(CITY_ID, cityId);
            cvDaily.put(DATE_UNIX, d.getTime());
            cvDaily.put(WEATHER_ID, d.getWeatherId());
            cvDaily.put(TEMP_MIN, d.getTemperatureMin());
            cvDaily.put(TEMP_MAX, d.getTemperatureMax());
            cvDaily.put(TEMP_MORN, d.getTemperatureMorning());
            cvDaily.put(TEMP_DAY, d.getTemperatureDay());
            cvDaily.put(TEMP_EVE, d.getTemperatureEvening());
            cvDaily.put(TEMP_NIGHT, d.getTemperatureNight());
            cvDaily.put(PRESSURE, d.getPressure());
            cvDaily.put(HUMIDITY, d.getHumidity());
            cvDaily.put(WIND_SPEED, d.getWindSpeed());
            cvDaily.put(WIND_DEGREE, d.getWindDegree());
            db.insert(DAILY_TABLE, null, cvDaily);
        }
        this.close();
        return true;
    }

    public Cursor getCursorCity() {
        db = this.getReadableDatabase();
        assert db != null;
        return db.query(CITY_TABLE, null, null, null, null, null, null);
    }

    public City getCityFormDb(long currentCityId) {
        City city = null;
        db = this.getReadableDatabase();
        String table = CITY_TABLE;
        String[] columns = {CITY_ID, CITY_NAME, COUNTRY_CODE, LATITUDE, LONGITUDE};
        String selection = CITY_ID + " = " + currentCityId;
        Cursor cursor = db.query(table, columns, selection, null, null, null, null);
        if (cursor.moveToFirst()) {
            int cityId = cursor.getInt(cursor.getColumnIndex(CITY_ID));
            String cityName = cursor.getString(cursor.getColumnIndex(CITY_NAME));
            String country = cursor.getString(cursor.getColumnIndex(COUNTRY_CODE));
//            double latitude = cursor.getDouble(cursor.getColumnIndex(LATITUDE));
//            double longitude = cursor.getDouble(cursor.getColumnIndex(LONGITUDE));
            city = new City(cityId, cityName, country);
        }
        this.close();
        return city;
    }

    public City getCityById(long _id) {
        City city = null;
        db = this.getReadableDatabase();
        String table = CITY_TABLE;
        String[] columns = {CITY_ID, CITY_NAME, COUNTRY_CODE, LATITUDE, LONGITUDE};
        String selection = "_id" + " = " + _id;
        Cursor cursor = db.query(table, columns, selection, null, null, null, null);
        if (cursor.moveToFirst()) {
            int cityId = cursor.getInt(cursor.getColumnIndex(CITY_ID));
            String cityName = cursor.getString(cursor.getColumnIndex(CITY_NAME));
            String country = cursor.getString(cursor.getColumnIndex(COUNTRY_CODE));
//            double latitude = cursor.getDouble(cursor.getColumnIndex(LATITUDE));
//            double longitude = cursor.getDouble(cursor.getColumnIndex(LONGITUDE));
            city = new City(cityId, cityName, country);
        }
        this.close();
        return city;
    }

    public Cursor getCursorHourly(int cityId, long time) {
        db = this.getReadableDatabase();
        Formatter formatter = new Formatter();
//        formatter.format("%s join %s on %s = %s", HOURLY_TABLE, CITY_TABLE,
//                CITY_TABLE_CITY_ID, HOURLY_TABLE_CITY_ID);
//        String table = formatter.toString();
        String table = getTableString(HOURLY_TABLE, HOURLY_TABLE_CITY_ID);
        String[] columns = {HOURLY_TABLE + "._id AS _id", DATE_UNIX, WEATHER_ID, TEMPERATURE,
                PRESSURE, HUMIDITY, WIND_SPEED, WIND_DEGREE};
//        formatter.format("%s = %d AND %d < %s", HOURLY_TABLE_CITY_ID, cityId, time, DATE_UNIX);
//        String selection = formatter.toString();
        String selection = getSelection(HOURLY_TABLE_CITY_ID, cityId, time);
        return db.query(table, columns, selection, null, null, null, null);
    }

    public Cursor getCursorDaily(int cityId, long time) {
        db = this.getReadableDatabase();
        Formatter formatter = new Formatter();
//        formatter.format("%s join %s on %s = %s", DAILY_TABLE, CITY_TABLE,
//                CITY_TABLE_CITY_ID, DAILY_TABLE_CITY_ID);
        String table = getTableString(DAILY_TABLE, DAILY_TABLE_CITY_ID);
        String[] columns = {DAILY_TABLE+"._id AS _id"  ,DATE_UNIX, WEATHER_ID, TEMP_MIN, TEMP_MAX,
                TEMP_MORN, TEMP_DAY, TEMP_EVE, TEMP_NIGHT, PRESSURE, HUMIDITY, WIND_SPEED,
                WIND_DEGREE};
        String selection = getSelection(DAILY_TABLE_CITY_ID, cityId, time);
        return db.query(table, columns, selection, null, null, null, null);
    }

    public ForecastHourly getHourlyItemFromDb(int cityId, long time) {
        logMsg("cityId="+cityId+" time="+time);
        ForecastHourly forecastHourly = null;
        db = this.getReadableDatabase();
        String table = getTableString(HOURLY_TABLE, HOURLY_TABLE_CITY_ID);
        String[] columns = {HOURLY_TABLE + "._id AS _id", DATE_UNIX, WEATHER_ID, TEMPERATURE,
                PRESSURE, HUMIDITY, WIND_SPEED, WIND_DEGREE};
        Formatter formatterSelection = new Formatter();
        formatterSelection.format("%s = %d AND %d < %s LIMIT 1", HOURLY_TABLE_CITY_ID, cityId, time,
                DATE_UNIX);
        String selection = formatterSelection.toString();
        Cursor cursor = db.query(table, columns, selection, null, null, null, null);
        if (cursor.moveToFirst()) {
            long dateUnix = cursor.getLong(cursor.getColumnIndex(DATE_UNIX));
            int weatherId = cursor.getInt(cursor.getColumnIndex(WEATHER_ID));
            double temperature = cursor.getDouble(cursor.getColumnIndex(TEMPERATURE));
            double pressure = cursor.getDouble(cursor.getColumnIndex(PRESSURE));
            double humidity = cursor.getDouble(cursor.getColumnIndex(HUMIDITY));
            double windSpeed = cursor.getDouble(cursor.getColumnIndex(WIND_SPEED));
            double windDeg = cursor.getDouble(cursor.getColumnIndex(WIND_DEGREE));

            forecastHourly = new ForecastHourly(dateUnix, weatherId, temperature, pressure, humidity,
                    windSpeed, windDeg);
        }
        this.close();
        return forecastHourly;
    }

    public boolean delRec(long _id) {
        db = this.getWritableDatabase();
        assert db != null;
        db.delete(CITY_TABLE, "_id" + " = " + _id, null);
        db.delete(HOURLY_TABLE, "_id" + " = " + _id, null);
        db.delete(DAILY_TABLE, "_id" + " = " + _id, null);
        db.close();
        return true;
    }

    private String getTableString(String table, String tableJoin) {
        Formatter formatter = new Formatter();
        formatter.format("%s join %s on %s = %s", table, CITY_TABLE, CITY_TABLE_CITY_ID, tableJoin);
        return formatter.toString();
    }

    private String getSelection(String tableCityId, int cityId, long time) {
        Formatter selectionFormatter = new Formatter();
        selectionFormatter.format("%s = %d AND %s > %d", tableCityId, cityId, DATE_UNIX, time);
        return selectionFormatter.toString();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String citySqlStr = "create table " + CITY_TABLE +
                "(_id integer primary key autoincrement, " +
                CITY_ID + " integer key, " +
                CITY_NAME + " text, " +
                COUNTRY_CODE + " text " +
                ");";
        db.execSQL(citySqlStr);

        String formatString = "create table %s (_id integer primary key autoincrement, " +
                "%s integer, %s integer, %s real, %s real, %s real, %s integer, " +
                "%s real, %s real);";
        Formatter formatter = new Formatter();
        formatter.format(formatString, HOURLY_TABLE, CITY_ID, DATE_UNIX, TEMPERATURE, PRESSURE,
                HUMIDITY, WEATHER_ID, WIND_SPEED, WIND_DEGREE);

        String sqlHourlyTableString = formatter.toString();
        db.execSQL(sqlHourlyTableString);

        String sqlDailyTableString = "create table " + DAILY_TABLE +
                " (_id integer primary key autoincrement, "+
                CITY_ID + " integer, " +
                DATE_UNIX + " integer, " +
                TEMP_DAY + " real, " +
                TEMP_MIN + " real, " +
                TEMP_MAX + " real, " +
                TEMP_NIGHT + " real, " +
                TEMP_EVE + " real, " +
                TEMP_MORN + " real, " +
                PRESSURE + " real, " +
                HUMIDITY + " real, " +
                WEATHER_ID + " integer, " +
                WIND_SPEED + " real, " +
                WIND_DEGREE + " real" +
                ");";
        db.execSQL(sqlDailyTableString);
    }

    protected void logMsg(String msg) {
        Log.d(C.LOG_TAG, ((Object) this).getClass().getSimpleName() + ": " + msg);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
