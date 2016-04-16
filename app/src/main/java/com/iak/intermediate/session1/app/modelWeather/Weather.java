package com.iak.intermediate.session1.app.modelWeather;

import java.io.Serializable;

/**
 * Created by hahn on 16/04/16.
 */
public class Weather implements Serializable {

    private int id;
    private String main;
    private String description;
    private String icon;

    public int getId() {
        return id;
    }


    /**
     *
     * @return
     *     The main
     */
    public String getMain() {
        return main;
    }

     /**
     *
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }


    /**
     *
     * @return
     *     The icon
     */
    public String getIcon() {
        return icon;
    }


}
