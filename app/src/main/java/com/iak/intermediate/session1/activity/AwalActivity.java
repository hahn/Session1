package com.iak.intermediate.session1.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iak.intermediate.session1.R;

public class AwalActivity extends AppCompatActivity {

    private Button btnMember, btnWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        btnMember = (Button) findViewById(R.id.btn_member);
        btnWeather = (Button) findViewById(R.id.btn_weather);


    }

    public void toMemberActivity(View view){
        Snackbar.make(view, "goto Member", Snackbar.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void toWeatherActivity(View view){
        Snackbar.make(view, "goto Weather", Snackbar.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), WeatherActivity.class);
        startActivity(intent);
    }
}
