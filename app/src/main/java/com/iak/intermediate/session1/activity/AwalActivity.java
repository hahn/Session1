package com.iak.intermediate.session1.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iak.intermediate.session1.R;

public class AwalActivity extends AppCompatActivity {

    private Button btnMember, btnWeather;
    private EditText edtCity;
    private String city = "Bandung";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        btnMember = (Button) findViewById(R.id.btn_member);
        btnWeather = (Button) findViewById(R.id.btn_weather);
        edtCity = (EditText) findViewById(R.id.edtCity);


    }

    public void toMemberActivity(View view){
        Snackbar.make(view, "goto Member", Snackbar.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void toWeatherActivity(View view){
//        Snackbar.make(view, "goto Weather", Snackbar.LENGTH_SHORT).show();

        city = edtCity.getText().toString();
        Intent intent = new Intent(getApplicationContext(), WeatherActivity.class);
        intent.putExtra("city", city);
        startActivity(intent);
    }
}
