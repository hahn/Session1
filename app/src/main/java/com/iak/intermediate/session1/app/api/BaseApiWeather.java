package com.iak.intermediate.session1.app.api;

import android.content.Context;

import com.radyalabs.async.AsyncHttpClient;
import com.radyalabs.async.AsyncHttpResponseHandler;
import com.radyalabs.async.RequestParams;

/**
 * Created by hahn on 16/04/16.
 */
public abstract class BaseApiWeather {

//    public static final String BASE_URL = "http://localhost/data/";
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
    protected Context context;
    protected RequestParams params;
    protected static String baseApi = BASE_URL;
    protected String endpointApi;
    protected AjaxType ajaxType;
    protected String jsonRaw;
    protected static final int timeOut = 60000;
    protected AsyncHttpResponseHandler responseHandler;
    protected String defaultMessage;

    protected String apiKey;

    protected enum AjaxType{
        POST,
        GET,
        DELETE,
        POST_RAW_JSON,
    }

    public BaseApiWeather(Context context){
        this.context = context;
        params = new RequestParams();
        endpointApi = "";
        ajaxType = AjaxType.GET;
        defaultMessage = "";
        apiKey = "";
    }

    protected void executeAjax(String url){
        AsyncHttpClient ajax = new AsyncHttpClient();

        ajax.setTimeout(timeOut);

        //get
        ajax.get(url, params, responseHandler);

    }

    public void executeAjax(){
        executeAjax(baseApi + endpointApi + apiKey);
    }

    abstract public void onFinishRequest(boolean success, String returnItem);
}
