package com.example.yuanmao.a12306_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class foodActivity extends AppCompatActivity {
    private Button foodfind;
    private TextView goData;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodlayout);
        foodfind = findViewById(R.id.btn_foodfind);
        goData = findViewById(R.id.godata);
        calendar = Calendar.getInstance();
        foodfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        goData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataChooseUtil.DataChoose(foodActivity.this,0,goData,calendar);
            }
        });
    }
}
