package com.iak.intermediate.session1.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.iak.intermediate.session1.R;
import com.iak.intermediate.session1.app.api.ApiGetWeather;
import com.iak.intermediate.session1.app.modelWeather.Weather;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by hahn on 16/04/16.
 */
public class WeatherActivity extends AppCompatActivity {

    private TextView txtCity, txtDesc, txtTemp, txtWind, txtPress, txtHumidity, txtTime, txtSunrise, txtSunset;
    private ImageView imgIcon;
    private String urlImg, city;
    private ProgressDialog loading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        loading = new ProgressDialog(this);
        loading.show();

        city = this.getIntent().getExtras().getString("city");

        txtCity = (TextView) findViewById(R.id.txt_weather_city);
        txtTime = (TextView) findViewById(R.id.txt_weather_time);
        txtDesc = (TextView) findViewById(R.id.txt_weather_description);
        txtTemp = (TextView) findViewById(R.id.txt_weather_temp);
        txtWind = (TextView) findViewById(R.id.txt_weather_wind);
        txtPress = (TextView) findViewById(R.id.txt_weather_pressure);
        txtHumidity = (TextView) findViewById(R.id.txt_weather_humidity);
        txtSunrise = (TextView) findViewById(R.id.txt_weather_sunrise);
        txtSunset = (TextView) findViewById(R.id.txt_weather_sunset);

        imgIcon = (ImageView) findViewById(R.id.img_weather_icon);

        urlImg = "http://openweathermap.org/img/w/";

        getData();
        Log.d("city: ", city);
    }

    private void getData(){
        ApiGetWeather apiGetWeather = new ApiGetWeather(getApplicationContext(), city){

            @Override
            public void onFinishRequest(boolean success, String returnItem) {
                Log.d("getData", "getData " + success);

                if (loading != null){
                    loading.dismiss();
                    loading = null;
                }

                if(success){
                    if(data != null){

                        List<Weather> weatherList = data.getWeather();
                        //gambar icon
                        urlImg += weatherList.get(0).getIcon()+".png";
                        Log.d("ImageIcon:", urlImg);

                        Picasso.with(context)
                                .load(urlImg)
                                .into(imgIcon);

                        //ubah dulu data time ke waktu normal
                        long unixTime, unixRise, unixSet;
                        Date date, dateRise, dateSet;
                        String fDate, fRise, fSet;
                        SimpleDateFormat sdf, sdfSetRise;
                        sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss ");
                        sdfSetRise = new SimpleDateFormat("HH:mm:ss");

                        unixTime = data.getDt();
                        date = new Date(unixTime * 1000);
                        fDate = sdf.format(date);

                        unixRise = data.getSys().getSunrise();
                        unixSet = data.getSys().getSunset();
                        dateRise = new Date(unixRise * 1000);
                        dateSet = new Date(unixSet * 1000);
                        fRise = sdfSetRise.format(dateRise);
                        fSet = sdfSetRise.format(dateSet);

                        txtCity.setText(data.getName() + ", " + data.getSys().getCountry());
                        txtTime.setText("get at " + fDate);
                        txtDesc.setText(weatherList.get(0).getDescription());
                        txtHumidity.setText(data.getMain().getHumidity() + "%");
                        txtPress.setText(data.getMain().getPressure() + " hpa");
                        txtTemp.setText(data.getMain().getTemp() + " C");
                        txtWind.setText(data.getWind().getSpeed() + " m/s");
                        txtSunrise.setText(fRise);
                        txtSunset.setText(fSet);

                    }
                }
            }
        };
        apiGetWeather.executeAjax();
    }
}
