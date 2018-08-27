package com.example.yuanmao.a12306_;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.litepal.LitePal;

public class TransActivity extends AppCompatActivity {
    private TextView textView;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        dbManager = new DBManager(this);
        dbManager.openDatabase();
        dbManager.closeDatabase();
        handler.sendEmptyMessageDelayed(0,600);
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            getHome();
            super.handleMessage(msg);
        }
    };
    private void getHome(){
        Intent intent = new Intent(TransActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
