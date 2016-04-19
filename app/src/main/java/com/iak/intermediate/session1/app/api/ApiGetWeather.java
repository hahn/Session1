package com.iak.intermediate.session1.app.api;

import android.content.Context;
import android.graphics.AvoidXfermode;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.iak.intermediate.session1.app.modelWeather.ModelWeather;
import com.radyalabs.async.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by hahn on 16/04/16.
 */
abstract public class ApiGetWeather extends BaseApiWeather {

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    protected ModelWeather data;
    private JsonObject object;
    private JsonObject json;

    private String rawContent;
    private Gson gson;
    private GsonBuilder gsonBuilder;

    public ApiGetWeather(Context context, String endpoint) {
        super(context);

        ajaxType = AjaxType.GET;
//        endpointApi = "bdg.json"; //untuk yg asli: "q=bandung,id&units=metric"
//        endpointApi = "q=bandung,id&units=metric";
        endpointApi = "q=" + endpoint + "&units=metric";
        apiKey = "&appid=b1b15e88fa797225412429c1c50c122a";


        responseHandler = new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] content) {
                try{
                    rawContent = new String(content);
                    json = new JsonParser().parse(rawContent).getAsJsonObject();
                    object = json.getAsJsonObject();

                    gsonBuilder = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer());
                    gson = gsonBuilder.create();

                    Log.d("onSuccess", rawContent);
                    data = gson.fromJson(object, ModelWeather.class);

                    onFinishRequest(true, rawContent);

                }
                catch (Exception e){
                    e.printStackTrace();
                    onFinishRequest(false, rawContent);
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] content, Throwable throwable) {
                String textContent = null;
                if (content != null){
                    textContent = new String(content);
                }
                onFinishRequest(false, textContent);
            }
        };
    }

    public void setEndpoint(String endpoint){
        this.endpointApi = endpoint;
    }

    private static final String[] DATE_FORMATS = new String[] {
            DATE_FORMAT
    };

    private class DateDeserializer implements JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonElement jsonElement, Type typeOF,
                                JsonDeserializationContext context) throws JsonParseException {
            for (String format : DATE_FORMATS) {
                try {
                    return new SimpleDateFormat(format).parse(jsonElement.getAsString());
                } catch (ParseException e) {
                }
            }
            throw new JsonParseException("Unparseable date: \"" + jsonElement.getAsString()
                    + "\". Supported formats: " + Arrays.toString(DATE_FORMATS));
        }
    }
}
