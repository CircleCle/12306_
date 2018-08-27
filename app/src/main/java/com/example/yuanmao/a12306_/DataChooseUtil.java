package com.example.yuanmao.a12306_;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by 张淦 on 2018/7/9.
 */

public class DataChooseUtil {
    public DataChooseUtil(){}

    public static void DataChoose(Activity activity,int themeId,final TextView tv_data, Calendar calendar){
        new DatePickerDialog(activity,
                themeId,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv_data.setText(year+"年"+month+"月"+dayOfMonth+"日");
                    }
                }
                ,calendar.get(Calendar.YEAR)
                ,calendar.get(Calendar.MONTH)
                ,calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public static void TimeChoose(Activity activity,int themeId,final TextView tv_time, Calendar calendar){
        new TimePickerDialog(activity,
                themeId,
                new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    tv_time.setText(hourOfDay+"时"+minute+"分");
                }
            }
            ,calendar.get(Calendar.HOUR_OF_DAY)
            ,calendar.get(Calendar.MINUTE)
            ,true).show();
    }
}
