package com.iak.intermediate.session1.app.modelWeather;

import java.io.Serializable;

/**
 * Created by hahn on 16/04/16.
 */
public class Wind implements Serializable {
    private float speed;
    private float deg;

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }
}
