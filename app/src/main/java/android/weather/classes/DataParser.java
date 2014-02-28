package android.weather.classes;


import android.weather.app.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataParser {

    public static Date getDate(long dateUnix) {
        Date date = new Date();
        date.setTime(dateUnix * 1000);
        return date;
    }

    public static String getDateString(String dateFormat, long dateUnix) {
        Date date = getDate(dateUnix);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateString = sdf.format(date);
        return dateString;
    }

    public static int getWindDirRes(double windDeg) {
        int windDirRes = R.string.n_a;
        if (windDeg >= 22.5 & windDeg < 67.5) {
            windDirRes = R.string.wind_NE_45;
        } else if (windDeg >= 67.5 & windDeg < 112.5) {
            windDirRes = R.string.wind_E_90;
        } else if (windDeg >= 112.5 & windDeg <157.5) {
            windDirRes = R.string.wind_SE_135;
        } else if (windDeg >= 157.5 & windDeg < 202.5) {
            windDirRes = R.string.wind_S_180;
        } else if (windDeg >= 202.5 & windDeg < 247.5) {
            windDirRes = R.string.wind_SW_225;
        } else if (windDeg >= 247.5 & windDeg < 292.5) {
            windDirRes = R.string.wind_W_270;
        } else if (windDeg >= 292.5 & windDeg < 337.5) {
            windDirRes = R.string.wind_NW_315;
        } else if (windDeg > 337.5) {
            windDirRes = R.string.wind_N_0;
        } else if (windDeg < 22.5) {
            windDirRes = R.string.wind_N_0;
        }

        return windDirRes;
    }

    public static int getWeatherIdRes(int weatherId) {
        int weatherIdRes= 0;
        switch (weatherId) {
            case 200: weatherIdRes = R.string.weatherId_200; break;
            case 201: weatherIdRes = R.string.weatherId_201; break;
            case 202: weatherIdRes = R.string.weatherId_202; break;
            case 210: weatherIdRes = R.string.weatherId_210; break;
            case 211: weatherIdRes = R.string.weatherId_211; break;
            case 212: weatherIdRes = R.string.weatherId_212; break;
            case 221: weatherIdRes = R.string.weatherId_221; break;
            case 230: weatherIdRes = R.string.weatherId_230; break;
            case 231: weatherIdRes = R.string.weatherId_231; break;
            case 232: weatherIdRes = R.string.weatherId_232; break;

            case 300: weatherIdRes = R.string.weatherId_300; break;
            case 301: weatherIdRes = R.string.weatherId_301; break;
            case 302: weatherIdRes = R.string.weatherId_302; break;
            case 310: weatherIdRes = R.string.weatherId_310; break;
            case 311: weatherIdRes = R.string.weatherId_311; break;
            case 312: weatherIdRes = R.string.weatherId_312; break;
            case 321: weatherIdRes = R.string.weatherId_321; break;

            case 500: weatherIdRes = R.string.weatherId_500; break;
            case 501: weatherIdRes = R.string.weatherId_501; break;
            case 502: weatherIdRes = R.string.weatherId_502; break;
            case 503: weatherIdRes = R.string.weatherId_503; break;
            case 504: weatherIdRes = R.string.weatherId_504; break;
            case 511: weatherIdRes = R.string.weatherId_511; break;
            case 520: weatherIdRes = R.string.weatherId_520; break;
            case 521: weatherIdRes = R.string.weatherId_521; break;
            case 522: weatherIdRes = R.string.weatherId_522; break;

            case 600: weatherIdRes = R.string.weatherId_600; break;
            case 601: weatherIdRes = R.string.weatherId_601; break;
            case 602: weatherIdRes = R.string.weatherId_602; break;
            case 611: weatherIdRes = R.string.weatherId_611; break;
            case 621: weatherIdRes = R.string.weatherId_621; break;

            case 701: weatherIdRes = R.string.weatherId_701; break;
            case 711: weatherIdRes = R.string.weatherId_711; break;
            case 721: weatherIdRes = R.string.weatherId_721; break;
            case 731: weatherIdRes = R.string.weatherId_731; break;
            case 741: weatherIdRes = R.string.weatherId_741; break;

            case 800: weatherIdRes = R.string.weatherId_800; break;
            case 801: weatherIdRes = R.string.weatherId_801; break;
            case 802: weatherIdRes = R.string.weatherId_802; break;
            case 803: weatherIdRes = R.string.weatherId_803; break;
            case 804: weatherIdRes = R.string.weatherId_804; break;
            default: weatherIdRes = -1;
        }
        return weatherIdRes;
    }

    public static int getIconIdRes(int weatherId, int timeOfDay) {
        int iconId = R.drawable.na;
//        switch (weatherId) {
//            case 200: iconId = R.drawable.t_200_d_n; break;
//            case 201: iconId = R.drawable.t_201_d_n; break;
//            case 202: iconId = R.drawable.t_202_d_n; break;
//            case 210: iconId = R.drawable.t_210_211_d_n; break;
//
//        }
        if (weatherId == 200) {
            iconId = R.drawable.t_200_d_n;
        } else if (weatherId == 201) {
            iconId = R.drawable.t_201_d_n;
        } else if (weatherId == 202) {
            iconId = R.drawable.t_202_d_n;
        } else if (weatherId == 210 || weatherId == 211) {
            iconId = R.drawable.t_210_211_d_n;
        } else if (weatherId == 212 || weatherId == 221) {
            iconId = R.drawable.t_212_221_d_n;
        } else if (weatherId == 230) {
            iconId = R.drawable.t_230_d_n;
        } else if (weatherId == 231) {
            iconId = R.drawable.t_231_d_n;
        } else if (weatherId == 232) {
            iconId = R.drawable.t_232_d_n;
        } else if (weatherId == 300) {
            iconId = R.drawable.d_300_310_d_n;
        } else if (weatherId == 301 || weatherId == 311) {
            iconId = R.drawable.d_301_311_d_n;
        } else if (weatherId == 302 || weatherId == 312) {
            iconId = R.drawable.d_302_312_d_n;
        } else if (weatherId == 313 || weatherId == 314 || weatherId == 321 || weatherId == 521 ||
                weatherId == 522 || weatherId == 531) {
            iconId = R.drawable.r_521_522_531_d_313_314_321_d_n;
        } else if (weatherId == 500) {
            iconId = R.drawable.r_500_d_n;
        } else if (weatherId == 501) {
            iconId = R.drawable.r_501_d_n;
        } else if (weatherId == 502 || weatherId == 503 || weatherId == 504) {
            iconId = R.drawable.r_502_503_504_d_n;
        } else if (weatherId == 511) {
            iconId = R.drawable.r_511_d_n;
        } else if (weatherId == 600 || weatherId == 620) {
            iconId = R.drawable.s_600_620_d_n;
        } else if (weatherId == 601 || weatherId == 621) {
            iconId = R.drawable.s_601_621_d_n;
        } else if (weatherId == 602 || weatherId == 622) {
            iconId = R.drawable.s_602_622_d_n;
        } else if (weatherId == 611 || weatherId == 612 || weatherId == 615 || weatherId == 616) {
            iconId = R.drawable.s_611_612_615_616_d_n;
        } else if (weatherId == 701 || weatherId == 711 || weatherId == 721 || weatherId == 741) {
            iconId = R.drawable.a_701_711_721_741_d_n;
        } else if (weatherId == 731 || weatherId == 751 || weatherId == 761) {
            iconId = R.drawable.a_731_751_761_d_n;
        } else if (weatherId == 800) {
            if (timeOfDay == C.DAY) iconId = R.drawable.c_800_d;
            if (timeOfDay == C.NIGHT) iconId = R.drawable.c_800_n;
        } else if (weatherId == 801) {
            if (timeOfDay == C.DAY) iconId = R.drawable.c_801_d;
            if (timeOfDay == C.NIGHT) iconId = R.drawable.c_801_n;
        } else if (weatherId == 802) {
            if (timeOfDay == C.DAY) iconId = R.drawable.c_802_d;
            if (timeOfDay == C.NIGHT) iconId = R.drawable.c_802_n;
        } else if (weatherId == 803) {
            if (timeOfDay == C.DAY) iconId = R.drawable.c_803_d;
            if (timeOfDay == C.NIGHT) iconId = R.drawable.c_803_n;
        } else if (weatherId == 804) {
            iconId = R.drawable.c_804_d_n;
        } else {
            iconId = R.drawable.na;
        }
        return iconId;
    }

    //todo convert temperature, pressure, wind speed
}
