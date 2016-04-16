package com.iak.intermediate.session1.app.modelWeather;

import java.io.Serializable;

/**
 * Created by hahn on 16/04/16.
 */
public class Sys implements Serializable {
    private int id;
    private String country;
    private int sunrise;
    private int sunset;

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }
}
