package com.iak.intermediate.session1.app.modelWeather;

import java.io.Serializable;

/**
 * Created by hahn on 16/04/16.
 */
public class MainTemp implements Serializable {
    private float temp;
    private float pressure;
    private float humidity;
    private float tempMin;
    private float tempMax;
    private float seaLevel;
    private float grndLevel;


    public float getTemp(){
        return temp;
    }

    public float getPressure(){
        return pressure;
    }

    public float getHumidity(){
        return humidity;
    }

    public float getTempMin(){
        return tempMin;
    }

    public float getTempMax(){
        return tempMax;
    }

    public float getSeaLevel(){
        return seaLevel;
    }

    public float getGrndLevel(){
        return grndLevel;
    }

}
