package com.example.yuanmao.a12306_;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TicketChooseActivity extends AppCompatActivity {

    private ListView stationList;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_area);
        stationList = findViewById(R.id.area_listview);

    }
}

