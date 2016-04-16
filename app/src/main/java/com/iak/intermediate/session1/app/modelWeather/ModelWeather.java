package com.iak.intermediate.session1.app.modelWeather;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hahn on 16/04/16.
 */
public class ModelWeather implements Serializable {

    private Coord coord;
    private List<Weather> weather = new ArrayList<Weather>();
    private MainTemp main;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private Sys sys;

    private String base;
    private int id;
    private String name;
    private long dt;
    private int cod;

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public MainTemp getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public long getDt() {
        return dt;
    }

    public String getName() {
        return name;
    }

    public String getBase() {
        return base;
    }

    public int getCod() {
        return cod;
    }
}
