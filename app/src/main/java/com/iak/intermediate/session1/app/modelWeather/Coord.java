package com.iak.intermediate.session1.app.modelWeather;

import java.io.Serializable;

/**
 * Created by hahn on 16/04/16.
 */
public class Coord implements Serializable {
    private double lon;
    private double lat;

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
