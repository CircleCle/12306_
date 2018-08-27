package com.example.yuanmao.a12306_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ChooseStationActivity extends AppCompatActivity {
    private ListView stationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_area);
        stationList = findViewById(R.id.area_listview);
    }
}
